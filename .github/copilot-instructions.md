<!-- .github/copilot-instructions.md for the JAUS repo -->
# Quick guidance for AI coding agents

This repository is a small multi-module Java project (two modules: `jauslib` and `jauscli`) built with Gradle. The goal of these instructions is to give an AI coding agent the minimal, concrete, repo-specific information needed to be productive.

1) Big picture
- Two modules:
  - `jauslib` — core domain model and logic: `Universe`, `World`, `WorldImpl`, `WorldMap`, `Guest`, exceptions like `InvalidLocationException` / `LocationNotFreeException`.
  - `jauscli` — a tiny command-line client that composes objects from `jauslib` and exercises the simulator (`CommandLineInterface.java`).
- Data flow: `CommandLineInterface` constructs a `Universe` (with a `Clock`), creates a `WorldImpl` backed by a `WorldMap` (e.g. `IdentityBasedMap`), supplies `Guest` instances and assigns them `Location`s via `GuestArrangementPolicy`.

2) Key files to inspect (quick links)
- `jauslib/src/main/java/me/alessandropetrozzelli/jaus/Universe.java` — entry point for the model, holds worlds by name.
- `jauslib/src/main/java/me/alessandropetrozzelli/jaus/WorldImpl.java` — delegates to `WorldMap`; contains `addGuest(s)` patterns.
- `jauscli/src/main/java/me/alessandropetrozzelli/jauscli/CommandLineInterface.java` — example usage and orchestration.
- Tests: `jauslib/src/test/java/...` contains `UniverseTest`, `WorldImplTest`, `GuestTest` — run these to validate behavior.

3) Build / test / run (concrete commands)
- Build everything and run tests (use the wrapper):
  - ./gradlew clean build
  - ./gradlew test
- Run the CLI (if the `run` task is not configured, build then execute the main class):
  - ./gradlew :jauscli:build
  - java -cp jauscli/build/classes/java/main:jauslib/build/classes/java/main me.alessandropetrozzelli.jauscli.CommandLineInterface

4) Project-specific patterns & conventions (do this, not generic advice)
- Factory via Supplier: `WorldImpl.addGuest` and `CommandLineInterface` use `Supplier<Guest>` to defer creation; follow this when adding tests or generators.
- World storage abstraction: `WorldImpl` delegates to a `WorldMap` (see `IdentityBasedMap`) — changes to placement policies should modify `WorldMap` implementations.
- Exceptions are used for domain validation (`InvalidLocationException`, `LocationNotFreeException`) — prefer keeping validation at the `WorldMap` layer.
- Package-private helpers: there are `isEmpty()` package-private checks used by tests; preserve visibility when modifying APIs unless tests are updated.

5) Integration & CI notes
- There is a Travis CI badge in `README.md` historically; CI may be configured externally. The canonical way to run checks locally is via the Gradle wrapper above.

6) Small contract for code changes
- Inputs: changes must compile with `./gradlew build` and relevant tests should pass with `./gradlew test`.
- Outputs: new or modified behavior should have a unit test in `jauslib/src/test/java/...` or `jauscli` test folder.
- Error modes: retain existing domain exceptions and throw them where current code does.

7) Quick debugging tips
- Import the project as a Gradle project in your IDE (IntelliJ/Eclipse). Set breakpoints in `CommandLineInterface` and `WorldImpl`/`Universe` to inspect flows.
- If reproducing a failing test, run just that test: `./gradlew :jauslib:test --tests "me.alessandropetrozzelli.jaus.UniverseTest"`

8) When merging existing agent docs
- No `.github/copilot-instructions.md` or AGENT.md was detected; preserve this file in future edits. If you find `AGENT.md`/`AGENTS.md` later, merge concrete commands (Gradle builds, test names) and repo-specific patterns.

If anything here is unclear, or you want this file to include examples for a specific change type (feature, refactor, bugfix), tell me which workflows you want prioritized and I will iterate.
