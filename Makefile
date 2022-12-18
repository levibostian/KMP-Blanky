SHELL = /bin/sh

buildjs:
	./gradlew jsMainClasses

# publishes kotlin modules to maven local for you to import in your KMP project.
# not what you want if you, for example, want to generate a JS file and import that into npm project.
publishMavenLocal:
	./gradlew publishToMavenLocal