# hello-nonmodular

Package a non-modular application.

## How to build

Build the non-modular Java application.
```
mvn clean package
```

Create a package file for Debian distributions.
```
docker compose build
docker compose run --rm deb-builder
```
