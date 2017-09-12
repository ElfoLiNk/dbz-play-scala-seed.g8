# $name$


## Run local application
`sbt run-local`


## Docker

### Developer environment

1. Create docker image

`\$ sbt docker-snapshot`

2. Execute docker image

`\$ docker run -e PLAY_HTTP_SECRET="app-secret-key" -i -p 9000:9000 -t $name$:0.1.0`


##Formatter

Code is formatted automatically on each source load by [scalafmt plugin](http://scalameta.org/scalafmt/).
Example: `sbt clean`, `sbt`, `sbt reload`, ...

The formatter configurations are in .scalafmt.conf file.
