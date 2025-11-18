#!/usr/bin/env bash
# Minimal Maven wrapper script.
# If `.mvn/wrapper/maven-wrapper.jar` is present it will be executed.
set -e
DIR="$(cd "$(dirname "$0")" && pwd)"
WRAPPER_JAR="$DIR/.mvn/wrapper/maven-wrapper.jar"
if [ -f "$WRAPPER_JAR" ]; then
  exec java -jar "$WRAPPER_JAR" "$@"
else
  echo "Maven wrapper JAR not found: $WRAPPER_JAR"
  echo "You can generate it locally with an installed Maven using:'mv -N io.takari:maven:wrapper' or install Maven and run 'mvn' directly."
  exit 1
fi
