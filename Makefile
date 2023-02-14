.DEFAULT_GOAL := build-run

clean:
        make -C app clean
        
build:
        make -C app build
        
install:
        make -C app install
        
run-dist:
	make -C run-dist
	
run-dist-stylish:
        make -C run-dist-stylish

run-dist-plain:
        make -C run-dist-plain
 
run-dist-json:
        make -C run-dist-json

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
