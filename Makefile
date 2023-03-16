.DEFAULT_GOAL := build-run

clean:
	make -C app clean
        
build:
	make -C app build
        
install:
	make -C app install
        
run-dist:
	make -C run-dist
	
run-dist-json-stylish:
	make -C run-dist-json-stylish

run-dist-json-plain:
	make -C run-dist-json-plain
 
run-dist-json:
	make -C run-dist-json
	
run-dist-json-default:
	make -C run-dist-json-default
	
run-dist-yml-stylish:
	make -C run-dist-yml-stylish
	
run-dist-yml-plain:
	make -C run-dist-yml-plain
	
run-dist-yml-json:
	make -C run-dist-yml-json
	
run-dist-yml-default:
	make -C run-dist-yml-default

run:
	make -C app run
        
test:
	make -C app test
        
report:
	make -C app report
        
lint:
	make -C app lint
        
update-deps:
	make -C app lupdate-deps
        
build-run: build run
	
	
.PHONY: build
