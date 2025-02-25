.PHONY: clean app deb rpm
.DEFAULT_GOAL := deb

app_name := hello-nonmodular
app_version := 1.0.0
app_release := 1

dest_dir := target

app_dir := $(dest_dir)/$(app_name)
app_file := $(app_dir)/lib/app/.jpackage.xml

jars_dir := $(dest_dir)/jars
jars := $(shell find $(jars_dir) -name '*.jar')

main_jar := $(app_name)-$(app_version).jar
main_class := org.example.DemoApplication

resource_dir := src/jpackage/resources/linux
resource_files := $(shell find $(resource_dir) -type f)

arch := $(shell uname -m)
ifeq ($(arch),x86_64)
    deb_arch := amd64
else
    deb_arch := $(arch)
endif

deb_file = $(dest_dir)/$(app_name)_$(app_version)_$(deb_arch).deb
rpm_file = $(dest_dir)/$(app_name)-$(app_version)-$(app_release).$(arch).rpm

app: $(app_file)
deb: $(deb_file)
rpm: $(rpm_file)

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

$(rpm_file): $(app_file)
	jpackage --verbose \
	--type rpm \
	--dest $(dest_dir) \
	--app-image $(app_dir) \
	--name $(app_name) \
	--app-version $(app_version) \

clean:
	@rm -rf $(app_dir)
	@rm -f $(deb_file)
	@rm -f $(rpm_file)
