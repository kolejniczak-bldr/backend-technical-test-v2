## Summary

TUI DX Backend technical Test v2

The base project uses lombok, so you have to install it. You can use the following
guide https://www.baeldung.com/lombok-ide

## Things of note:

Commit structure, and the evolution of the project can be
found [here](https://github.com/kolejniczak-bldr/backend-technical-test-v2) as a public fork of the TUI DX Backend test

As for now, no database migration is provided, but if the project would grow, a database migrations framework would be
added, like liquibase, or flyway.

More business-adjacent questions are added to the [QUESTIONS.md](QUESTIONS.md)

## Testing

A `backend-technical-test-rest-assured` module lies inside the project, which allows for Test Driven Development, as it
contains REST Assured to write endpoint tests, and possibly e2e API tests.

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
