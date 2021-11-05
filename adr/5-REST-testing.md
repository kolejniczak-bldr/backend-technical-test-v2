# 5. REST enpoints testing with REST Assured

Date: 2021-11-05

## Status

Accepted

## Context

A way for quick testing of checking endpoints is needed. THis would provide TDD capabilities

## Decision

The choice was the [REST-Assured](https://rest-assured.io/) framework in a separate module inside the main project
directory.

## Consequences

A REST-Assured module is added to the project, which, with the project running, can be run separately, as a suite or
test by test.
