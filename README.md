# Music_Dept_Perf_Library
Final Project with JLadyman #backendbootcamp @PromineoTech

Description: This project is the beginning of a system that would allow departments to track, log, edit, and delete performances within their music department, including performance dates, performance titles, songs or pieces included, ensembles performing the pieces, and members of those ensembles. 

Motivation: As music graduates and teachers, Jordan and Chelsea thought it would be fun to focus their project on something msuic-performance related. It would be helpful to be able to pull up a list of performances and what songs/ensembles were included, different iterations of pieces by the same name but different composers, different times the same piece was performed, what types of ensembles performed the same piece, etc. 

Build Status: The current build status of this project includes CRUD operations for the "Performances" entity, CRUD Tests on the "Performances" entity, and read operations for the other entities. 

ERD: [music_dept_perf_library_erd.pdf](https://github.com/cperrine19/Music_Dept_Perf_Library/files/8980378/music_dept_perf_library_erd.pdf)

Tech/Framework used: Maven, SpringBoot, lombok, mysql, h2, swagger

Features: 

API reference
{"openapi":"3.0.1","info":{"title":"Create a Performance"},"servers":[{"url":"http://localhost:8080","description":"Local server."}],"paths":{"/createPerformances":{"post":{"tags":["default-create-performance-controller"],"summary":"Create a performance","description":"Returns the created performance","operationId":"createPerformance","parameters":[{"name":"Create a Performance Date","description":"The specified date (in this format: 2020-01-11)"},{"name":"Create a Performance Name","description":"The name of the performance (i.e. Johns Senior Recital)"}],"requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/CreatePerformance"}}},"required":true},"responses":{"201":{"description":"The created performance is returned","content":{"application/json":{"schema":{"$ref":"#/components/schemas/Performances"}}}},"400":{"description":"The request parameters are invalid","content":{"application/json":{}}},"404":{"description":"No performances were found with the input criteria","content":{"application/json":{}}},"500":{"description":"An unplanned error occurred","content":{"application/json":{}}}}}},"/performances":{"get":{"tags":["default-performance-controller"],"summary":"Returns a list of performances","description":"Returns a list of performances given specific parameters","operationId":"fetchPerformances","parameters":[{"name":"date","in":"query","description":"The specified date (i.e. '2020-01-11')","required":false,"schema":{"type":"string"}},{"name":"name","in":"query","description":"The name of the performance (i.e. Johns Senior Recital)","required":false,"schema":{"type":"string"}}],"responses":{"200":{"description":"A list of performances is returned","content":{"application/json":{"schema":{"$ref":"#/components/schemas/Performances"}}}},"400":{"description":"The request parameters are invalid","content":{"application/json":{}}},"404":{"description":"No performances were found with the input criteria","content":{"application/json":{}}},"500":{"description":"An unplanned error occurred","content":{"application/json":{}}}}}},"/ensembles":{"get":{"tags":["default-ensembles-controller"],"summary":"Returns a list of ensembles","description":"Returns a list of ensembles given specific parameters","operationId":"fetchEnsembles","parameters":[{"name":"ensemble_name","in":"query","description":"The name of the ensemble (i.e. Duet1)","required":false,"schema":{"type":"string"}},{"name":"member_size","in":"query","description":"The size of the ensemble (i.e. 2)","required":false,"schema":{"type":"integer","format":"int32"}}],"responses":{"200":{"description":"A list of ensembles is returned","content":{"application/json":{"schema":{"$ref":"#/components/schemas/Ensembles"}}}},"400":{"description":"The request parameters are invalid","content":{"application/json":{}}},"404":{"description":"No ensembles were found with the input criteria","content":{"application/json":{}}},"500":{"description":"An unplanned error occurred","content":{"application/json":{}}}}}},"/deletePerformance":{"delete":{"tags":["default-delete-performance-controller"],"summary":"Delete a performance","description":"Deletes a performance","operationId":"deletePerformance","parameters":[{"name":"Insert a Performance Date","description":"The specified date (in this format: 2020-01-11)"},{"name":"Insert a Performance Name","description":"The name of the performance (i.e. Johns Senior Recital)"}],"requestBody":{"content":{"application/json":{"schema":{"$ref":"#/components/schemas/DeletePerformance"}}},"required":true},"responses":{"202":{"description":"Accepted: The performance is deleted","content":{"application/json":{"schema":{"$ref":"#/components/schemas/Performances"}}}},"400":{"description":"The request parameters are invalid","content":{"application/json":{}}},"404":{"description":"No performances were found with the input criteria","content":{"application/json":{}}},"500":{"description":"An unplanned error occurred","content":{"application/json":{}}}}}}},"components":{"schemas":{"Composer":{"type":"object","properties":{"composer_pk":{"type":"integer","format":"int32"},"first_name":{"type":"string"},"last_name":{"type":"string"}}},"Ensembles":{"type":"object","properties":{"ensemble_pk":{"type":"integer","format":"int32"},"ensemble_name":{"type":"string"},"member_size":{"type":"integer","format":"int32"},"performances":{"type":"array","items":{"$ref":"#/components/schemas/Performances"}},"performers":{"type":"array","items":{"$ref":"#/components/schemas/Performers"}}}},"Performances":{"type":"object","properties":{"performance_name":{"type":"string"},"performance_date":{"type":"string"},"songs":{"type":"array","items":{"$ref":"#/components/schemas/Songs"}},"ensembles":{"type":"array","items":{"$ref":"#/components/schemas/Ensembles"}}}},"Performers":{"type":"object","properties":{"performer_pk":{"type":"integer","format":"int32"},"first_name":{"type":"string"},"last_name":{"type":"string"},"instrumentVoiceType":{"type":"string","enum":["FLUTE","CLARINET","SAXOPHONE","TRUMPET","FRENCH_HORN","TROMBONE","EUPHONIUM","TUBA","PERCUSSION","SOPRANO","ALTO","TENOR","BASS"]}}},"Songs":{"type":"object","properties":{"song_pk":{"type":"integer","format":"int32"},"composer":{"$ref":"#/components/schemas/Composer"},"song_title":{"type":"string"},"song_type":{"type":"string","enum":["SOLO","DUET","TRIO","QUARTET","QUINTET"]}}},"CreatePerformance":{"required":["performance_date","performance_name"],"type":"object","properties":{"performance_date":{"type":"string"},"performance_name":{"pattern":"[\\w\\s]*","type":"string"}}},"DeletePerformance":{"required":["performance_date","performance_name"],"type":"object","properties":{"performance_date":{"type":"string"},"performance_name":{"pattern":"[\\w\\s]*","type":"string"}}}}}}

Tests: We currently have implemented the following tests: CreatePerformancesTest, DeletePerformancesTest, FetchPerformancesTest, and UpdatePerformancesTest

Credits
Jordan Ladyman @ladymanj
Chelsea Perrine @cperrine19

Thank you to:
@PromineoTech #backendbootcamp
Dr.Rob Hewitt @DrOldGuy
