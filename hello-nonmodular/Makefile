.PHONY: clean app deb
.DEFAULT_GOAL := deb

app_name := hello-nonmodular
app_version := 1.0.0

dest_dir := target

app_dir := $(dest_dir)/$(app_name)
app_file := $(app_dir)/lib/app/.jpackage.xml

jars_dir := $(dest_dir)/jars
jars := $(shell find $(jars_dir) -name '*.jar')

main_jar := hello-nonmodular-1.0.0.jar
main_class := org.example.DemoApplication

resource_dir := src/jpackage/resources/linux
resource_files := $(shell find $(resource_dir) -type f)

package_arch := $(shell dpkg-architecture -q DEB_BUILD_ARCH)
deb_file := $(dest_dir)/$(app_name)_$(app_version)_$(package_arch).deb

app: $(app_file)
deb: $(deb_file)

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

$(deb_file): $(app_file) $(resource_files)
	jpackage --verbose \
	--type deb \
	--dest $(dest_dir) \
	--app-image $(app_dir) \
	--name $(app_name) \
	--app-version $(app_version) \
	--resource-dir $(resource_dir)

clean:
	@rm -rf $(app_dir)
	@rm -f $(deb_file)
