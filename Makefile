.PHONY: package package-prod cljs cljs-prod build-cljs build-cljs-prod clean

package:
	./build app.nw

package-prod:
	./build app-prod.nw

app.nw: clean build-cljs package

app-prod.nw: clean build-cljs-prod package-prod

cljs:
	lein cljsbuild auto dev

cljs-prod:
	lein cljsbuild auto prod

build-cljs:
	lein cljsbuild once dev

build-cljs-prod:
	lein cljsbuild once prod

clean:
	@mv node_modules/README.md README.md_123456789~
	-rm -rf node_modules/*
	@mv README.md_123456789~ node_modules/README.md
	-rm -f app.nw app-prod.nw
