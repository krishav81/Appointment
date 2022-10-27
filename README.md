# Appointment
API for Appointment Booking

**Run as a Spring Boot application

REST Endpoints

1.GET request to return specific appointments - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3

2.GET request to return all appointments - /api/v1/appointments/

http://localhost:PORT/api/v1/appointments/

3.GET request to return all appointments based on a date range - /api/v1/appointments/getRange

{
      "startDate":"2022-10-26",
      "endDate":"2022-10-28"
}

4.POST request to add new appointments - /api/v1/appointments/create

http://localhost:PORT/api/v1/appointments/create

Pass Body as JSON:

{
	"appointmentDate":"2022-10-29",
	"appointmentTime":"11:00:00",
	"duration":"02:00",
	"description":"Des"
}

5.PUT request to update appointments - /api/v1/appointments/

http://localhost:PORT/api/v1/appointments/

Pass Body as JSON:

{
	"Id":"1"
	"appointmentDate":"2022-10-29",
	"appointmentTime":"11:00:00",
	"duration":"02:00",
	"description":"Des"
}

6.DELETE request to delete specific appointments - /api/v1/appointments/{appointmentId}

http://localhost:PORT/api/v1/appointments/3

**Port Number**

localhost default port number : 8081

** Swagger URL **

http://localhost:8081/swagger-ui/index.html#

** Exception Handling Response: **

{
   "timestamp": "2022-10-27T04:33:02.679+00:00",
   "message": "To Date cannot be before From Date for the Date Range Requested",
   "details": "uri=/api/v1/appointments/getRange"
}

{
   "timestamp": "2022-10-27T04:40:26.397+00:00",
   "message": "Date Not Valid",
   "details": "uri=/api/v1/appointments/create"
}

{
   "timestamp": "2022-10-27T05:04:12.111+00:00",
   "message": "Time Cannot be Null",
   "details": "uri=/api/v1/appointments/create"
}

{
   "timestamp": "2022-10-27T05:10:12.976+00:00",
   "message": "Time Format Not Valid",
   "details": "uri=/api/v1/appointments/create"
}
