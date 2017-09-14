# $name$


## Run local application
`sbt run-local`


## Docker

### Developer environment

1. Create docker image

`\$ sbt docker-snapshot`

2. Execute docker image

`\$ docker run -e PLAY_HTTP_SECRET="app-secret-key" -i -p 9000:9000 -t $name$:0.1.0`


## Logging

### Custom logger
The trait `src/main/scala/$package$/logging/CustomLogger.scala` is a
placeholder in order to expand and insert a more complex logger.

### Basic logging filter
The class `src/main/scala/$package$/playcustom/filter/Filters.scala` is a basic logging filter for print out all incoming requests.


## Formatter

Code is formatted automatically on each source load by [scalafmt plugin](http://scalameta.org/scalafmt/).
Example: `sbt clean`, `sbt`, `sbt reload`, ...

The formatter configurations are in .scalafmt.conf file.
