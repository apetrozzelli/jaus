# jaus
Just Another Universe Simulator (as [yaus](https://github.com/apetrozzelli/yaus), but in Java)

[![Build Status](https://travis-ci.org/apetrozzelli/jaus.svg?branch=master)](https://travis-ci.org/apetrozzelli/jaus)

[![Dependencies Status](https://www.versioneye.com/user/projects/591567c5eb858e002c315441/badge.svg?style=flat-square)](https://www.versioneye.com/user/projects/591567c5eb858e002c315441?child=summary)

## AI coding agent instructions

This repository includes a short guide for AI coding agents and contributors in `.github/copilot-instructions.md`. It documents the project structure, build/test commands, and repo-specific development patterns. Read that file before making automated or large changes.

## Maven (migration)

This repository now includes Maven POMs to build the project with Apache Maven 4 (multi-module layout).

Quick commands (from the repo root):

```bash
# build modules and run tests
mvn -T 1C clean install

# run a specific module's tests
mvn -pl jauslib -am test

# run the CLI from the built classes (classpath includes jauscli and jauslib)
java -cp jauscli/target/classes:jauslib/target/classes me.alessandropetrozzelli.jauscli.CommandLineInterface
```

If you prefer the Gradle configuration it is still present, but Maven is the canonical build going forward.
