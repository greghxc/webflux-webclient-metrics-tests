## Usage
`POST` to http://localhost:8080/trigger

```json
{
  "paramA": "whatever",
  "paramB": "whatever"
}
```

```bash
http POST localhost:8080/trigger < payload.json
http POST localhost:8080/trigger "paramA=blah blah" "paramB=+123"
```