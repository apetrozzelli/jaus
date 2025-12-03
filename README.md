# jaus
Just Another Universe Simulator (as [yaus](https://github.com/apetrozzelli/yaus), but in Java)

[![Open in GitHub Codespaces](https://github.com/codespaces/badge.svg)](https://codespaces.new/apetrozzelli/jaus?quickstart=1)

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
