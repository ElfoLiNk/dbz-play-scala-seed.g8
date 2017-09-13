# dbz-play-scala-seed.g8

Giter8 template for generating a Databiz Play project seed in Scala.  

This project is intended for people who know how to use Play and want to get started right away.

You should only need to clone this project if you are modifying the giter8 template.  For information on giter8 templates, please see http://www.foundweekends.org/giter8/

## What's the difference from play-scala-seed?
This project was designed to be a professional out-of-the-box template.
The differences between this template and official [play-scala-seed](https://github.com/playframework/play-scala-seed.g8) are:

* Basic configurations: configurations defined application.conf instead of build.sbt;
* Formatter: code is formatted automatically by [scalafmt plugin](http://scalameta.org/scalafmt/);
* Project Module: play has a single project module with sbt default layout, instead of play layout;
* Docker: create docker image and publish locally by [sbt-native-packager](https://github.com/sbt/sbt-native-packager);
* Logging: placeholder in order to expand and insert a more complex logger;

## Running

If you want to create a project:

```
sbt new databizdevteam/dbz-play-scala-seed.g8
```

## Scaffolding 

Type `g8Scaffold form` from sbt to create the scaffold controller, template and tests needed to process a form.

## Running locally

If you are testing this giter8 template locally, you should [install g8](http://www.foundweekends.org/giter8/setup.html) and then run the [local test](http://www.foundweekends.org/giter8/testing.html) feature:

```
g8 file://dbz-play-scala-seed.g8/ --name=my-seed-test --force
```

Will create an example template called `my-seed-test`, for example.
