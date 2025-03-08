.PHONY: clean link
.DEFAULT_GOAL := link

dest_dir := target

jars_dir := $(dest_dir)/jars
jars := $(shell find $(jars_dir) -name '*.jar')

runtime_dir := $(dest_dir)/runtime
runtime_file := $(runtime_dir)/release

main_module := org.example.hello
main_class := org.example.DemoApplication

link: $(runtime_file)

$(runtime_file): $(jars)
	@rm -rf $(runtime_dir)
	jlink --verbose \
	--module-path $(JAVA_HOME)/jmods:$(jars_dir) \
	--add-modules $(main_module),ch.qos.logback.classic \
	--strip-debug --no-man-pages --no-header-files \
	--launcher jlink-launcher=$(main_module)/$(main_class) \
	--output $(runtime_dir)

clean:
	@rm -rf $(runtime_dir)
