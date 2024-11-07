# Backend

Download java 17: [Download](https://builds.openlogic.com/downloadJDK/openlogic-openjdk-jre/17.0.13+11/openlogic-openjdk-jre-17.0.13+11-windows-x64.zip)


## Run Locally

Clone the project

```bash
  git clone --single-branch --branch deployment-branch https://github.com/ecegroup2/backend.git
```

Go to the project directory

```bash
  cd backend
```

Start the server

```bash
   java -jar backend-0.0.1-SNAPSHOT.jar
```


## API Reference
[localhost:9080](localhost:9080/swagger-ui/index.html)
#### Get all items

```http
  GET /api/data/get
```

#### ADD item

```http
  ADD /api/data/add
```

| Request Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `data`      | `json` | **Required**. Id of item to fetch |


#### Delete item

```http
  DELETE /api/data/delete/{id}
```

|Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Int` | **Required**. Id of item to fetch |
