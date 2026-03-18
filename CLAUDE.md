# CLAUDE.md

This file provides guidance for AI assistants (e.g., Claude Code) working in this repository.

---

## Repository Overview

**Repository:** `danielrab21005/Claude`
**Status:** Initial setup — no source files yet. This file documents conventions and workflows for future development.

---

## Git Workflow

### Branch Naming
- Feature branches must follow the pattern: `claude/<description>-<session-id>`
- Example: `claude/add-claude-documentation-TWsow`
- Never push directly to `main` or `master` without explicit permission.

### Commit Messages
- Use clear, descriptive messages in the imperative mood: `Add feature X`, `Fix bug in Y`, `Update Z documentation`
- Reference issue or task IDs when applicable.

### Push Protocol
Always push with upstream tracking:
```bash
git push -u origin <branch-name>
```

On network failure, retry with exponential backoff: 2s → 4s → 8s → 16s (max 4 retries).

### Fetch/Pull
Prefer fetching specific branches:
```bash
git fetch origin <branch-name>
git pull origin <branch-name>
```

---

## Development Conventions

### Code Style
- Prefer editing existing files over creating new ones.
- Keep changes minimal and focused — do not refactor surrounding code unless asked.
- Do not add docstrings, comments, or type annotations to unchanged code.
- Avoid over-engineering: three similar lines is better than a premature abstraction.

### Security
- Never introduce SQL injection, XSS, command injection, or other OWASP Top 10 vulnerabilities.
- Validate input only at system boundaries (user input, external APIs).
- Never commit secrets, credentials, or `.env` files.

### File Management
- Do not create documentation files (`.md`, `README`) unless explicitly requested.
- Do not create helper utilities or abstractions for one-time operations.
- Delete unused code outright — do not leave `// removed` comments or rename to `_unused`.

---

## AI Assistant Instructions

### Task Execution
1. Read files before modifying them — never propose changes to unread code.
2. For multi-step tasks, use a todo list to track progress.
3. Mark tasks complete immediately after finishing, not in batches.
4. Only one task should be `in_progress` at a time.

### Reversibility & Risk
- Take local, reversible actions freely (edit files, run tests).
- For destructive or shared-system actions (force-push, drop DB, send messages), confirm with the user first.
- A one-time approval does not grant ongoing permission for the same action.

### Tool Preferences
| Task | Preferred Tool |
|---|---|
| Read files | `Read` tool (not `cat`) |
| Edit files | `Edit` tool (not `sed`/`awk`) |
| Create files | `Write` tool (not heredoc/echo) |
| Search files | `Glob` tool (not `find`) |
| Search content | `Grep` tool (not `grep`/`rg`) |
| System commands | `Bash` tool |

### Tone & Output
- Be concise — lead with action, not reasoning.
- Do not use emojis unless explicitly requested.
- Reference file locations as `path/file.ext:line_number` for easy navigation.

---

## Environment

- **Platform:** Linux
- **Shell:** bash/zsh
- **Model:** Claude Sonnet 4.6 (`claude-sonnet-4-6`)
- **Working directory:** `/home/user/Claude`

---

## Adding New Content

When the project grows, update this file to include:
- **Project structure** — directory layout and purpose of each folder
- **Tech stack** — languages, frameworks, and key libraries
- **Setup instructions** — how to install dependencies and run the project locally
- **Testing** — how to run tests and what coverage is expected
- **Deployment** — build and deploy commands/pipelines
- **Environment variables** — required env vars and where to define them
