#!/usr/bin/env bash
# Run the org.mmcc.Main program via Gradle, interactive mode, clean output

# Optional: set JAVA_HOME if you want a specific JDK
export JAVA_HOME="/usr/lib/jvm/java-25-openjdk"
export PATH="$JAVA_HOME/bin:$PATH"

# Run Gradle with stdin, plain console, no daemon
./gradlew run \
  --console=plain \
  --no-daemon