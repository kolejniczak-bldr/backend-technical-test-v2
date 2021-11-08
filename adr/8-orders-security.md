# 8. Providing security for orders endpoint

Date: 2021-11-05

## Status

Approved

## Context

A kind of security was required for the `/orders` searching all endpoint. Possibilities were multiple, from user
verification, with persisting users, additional layer of Spring Security, or as simple as a JWT token, that can be
easily changed, enhanced, and switched out.

## Decision

Due to time constraints a bare minimum was implemented with a JSON Web Token (JWT) with a payload containing `isValid`.

## Consequences

Listing and filtering orders now requires a JWT token with valid payload to be available. Security as of now is minimal,
but can be improved upon.
