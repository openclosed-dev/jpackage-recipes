app_name := hello-nonmodular
app_version := 1.0.0
app_arch := amd64

dest_dir := target
app_dir := $(dest_dir)/$(app_name)
app_file := $(app_dir)/lib/app/.jpackage.xml

jars_dir := $(dest_dir)/jars
jars := $(shell find $(jars_dir) -name '*.jar')

main_jar := hello-nonmodular-1.0.0.jar
main_class := org.example.DemoApplication

package_type := deb
package_file := $(dest_dir)/$(app_name)_$(app_version)_$(app_arch).$(package_type)

.PHONY: all clean

all: $(package_file)

$(app_file): $(jars)
	@rm -rf $(app_dir)
	jpackage --verbose \
	--type app-image \
	--dest $(dest_dir) \
	--name $(app_name) \
	--app-version $(app_version) \
	--input $(jars_dir) \
	--main-jar $(main_jar) \
	--main-class $(main_class)

$(package_file): $(app_file)
	jpackage --verbose \
	--type $(package_type) \
	--dest $(dest_dir) \
	--app-image $(app_dir) \
	--name $(app_name) \
	--app-version $(app_version)

clean:
	@rm -rf $(app_dir)
	@rm -f $(package_file)
