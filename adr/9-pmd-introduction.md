# 9. Usage of PMD

Date: 2021-11-05

## Status

Approved

## Context

A fast and easy static code analysis tool should be used to prevent simple mistakes in code. It should be usable inside
the developer's environment. Examples are PMD or SonarQube

## Decision

With access to a previously prepared ruleset for PMD, its familiarity and a lack of SonarQube instance available, PMD
will be implemented. Additionally, PMD doesn't use an external instance for it's full capabilities, however SonarQube is
more robust and thorough.

## Consequences

All developers must use [PMD](https://pmd.github.io/latest/index.html) for static code analysis. Future possible
addition of SonarQube will allow for cross-examination. 
