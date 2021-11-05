## Summary

TUI DX Backend technical Test v2

The base project uses lombok, so you have to install it. You can use the following
guide https://www.baeldung.com/lombok-ide

## Thing to note:

Commit structure, and the evolution of the project can be
found [here](https://github.com/kolejniczak-bldr/backend-technical-test-v2) as a public fork of the TUI DX Backend test

## Methodologies

For standardising commit messages [ConventionalCommits](https://www.conventionalcommits.org/) is used.

#### Commit types:

**`fix`**: patches a bug in your codebase (this correlates with PATCH in semantic versioning).

**`feat`**: introduces a new feature to the codebase (this correlates with MINOR in semantic versioning).

**`test`**: adding missing tests or correcting existing tests

**`chore`**: other changes that don't modify src or test files

**`build`**: Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)

#### Commit structure

```
<type>[(optional scope)]: <description>

[optional body]

[optional footer]
```

## Important documents

### Architecture Decision Records

Architecture Decision Records (_ADRs_ for short), will be used to maintain context and reasoning of each architectural
decision.
