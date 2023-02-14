.DEFAULT_GOAL := build-run

clean:
	./gradlew clean
        
build:
	./gradlew clean build
        
install:
	./gradlew clean install
        
run-dist:
	./build/install/app/bin/app -h
	
run-dist-stylish:
	./build/install/app/bin/app -f stylish
	./src/main/resources/filepath1.json
	./src/main/resources/filepath2.json

run-dist-plain:
	./build/install/app/bin/app -f plain
	./src/main/resources/nestedFile1.yml
	./src/main/resources/nestedFile2.yml
 
run-dist-json:
	./build/install/app/bin/app -f json
	./src/main/resources/nestedFile1.json
	./src/main/resources/nestedFile2.yml

run:
	./gradlew run
        
test:
	./gradlew test
        
report:
	./gradlew jacocoTestReport
        
lint:
	./gradlew checkstyleMain checkstyleTest
        
update-deps:
	./gradlew useLatestVersions
        
build-run: build run
	
	
.PHONY: build
