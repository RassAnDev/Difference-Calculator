.DEFAULT_GOAL := build-run

clean:
	./gradlew clean
        
build:
	./gradlew clean build
        
install:
	./gradlew clean install
        
run-dist:
	./build/install/app/bin/app -h
	
run-dist-json-stylish:
	./build/install/app/bin/app -f stylish ./src/main/resources/filepath1.json ./src/main/resources/filepath2.json
	
run-dist-json-plain:
	./build/install/app/bin/app -f plain ./src/main/resources/filepath1.json ./src/main/resources/filepath2.json
	
run-dist-json:
	./build/install/app/bin/app -f json ./src/main/resources/filepath1.json ./src/main/resources/filepath2.json
	
run-dist-json-default:
	./build/install/app/bin/app ./src/main/resources/filepath1.json ./src/main/resources/filepath2.json

run-dist-yml-stylish:
	./build/install/app/bin/app -f stylish ./src/main/resources/filepath1.yaml ./src/main/resources/filepath2.yaml
	
run-dist-yml-plain:
	./build/install/app/bin/app -f plain ./src/main/resources/filepath1.yaml ./src/main/resources/filepath2.yaml
	
run-dist-yml-json:
	./build/install/app/bin/app -f json ./src/main/resources/filepath1.yaml ./src/main/resources/filepath2.yaml
 
run-dist-yml-default:
	./build/install/app/bin/app ./src/main/resources/filepath1.yaml ./src/main/resources/filepath2.yaml

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
