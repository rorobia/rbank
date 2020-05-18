# rbank

This is a simple spring boot application that generates project schedule based on the task dependencies(subtasks) and duration.


To run the application:
***
Upon cloning the project, run the project in the project root directory using `mvn spring-boot:run`

The project will initialize at port(s): 8080 (http). There is only 1 endpoint at `http://localhost:8080/calendar-schedule` using `GET` request.

`Sample cURL Request`
```
curl --location --request GET 'http://localhost:8080/calendar-schedule' \
--header 'Content-Type: application/json' \
--data-raw '[
	{
		"duration": 1
	
	},
	{
		"duration": 3,
		"subTasks" : [
			{
				"duration" : 4
			},
			{
				"duration" : 5
			}
		]
	}
]'
```

`Request Structure`
```
 duration - `Long` value for number of days
 subtask - Array of task where the task is dependent
```

`Sample Response`

```
[
    {
        "duration": 1,
        "startDate": "2020-05-18",
        "endDate": "2020-05-19",
        "subTasks": []
    },
    {
        "duration": 3,
        "startDate": "2020-05-29",
        "endDate": "2020-06-01",
        "subTasks": [
            {
                "duration": 4,
                "startDate": "2020-05-18",
                "endDate": "2020-05-22"
            },
            {
                "duration": 5,
                "startDate": "2020-05-23",
                "endDate": "2020-05-28"
            }
        ]
    }
]
```


`Response Structure`
```
 duration - `Long` value for number of days
 subtask - Array of task where the task is dependent
 startDate - date when will the task/subtask starts
 endDate - date when will task/subtask ends

 (Note that the start date on the parent task always depends on subtask end dates, if any)
```
