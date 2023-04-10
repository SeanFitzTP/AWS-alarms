## Builds application, deploys application, and runs cloud tests
all: build deploy test

.PHONY: clean build deploy

## Builds the native executable and runs unit tests. Increase Docker memory if this is taking too long or timing out.
build:
	./manageAWS.sh build

## Cleans the build directory
clean:
	./manageAWS.sh clean

## Deploys stack. If run locally, your sandbox is deployed. Pre-requisite: build
deploy:
	./manageAWS.sh deploy

## Destroys stack. If run locally, your sandbox is destroyed.
destroy:
	./manageAWS.sh destroy

## Runs the outside-in Cloud test suite. Pre-requisite: deploy
test:
	./manageAWS.sh test

## Diffs against the currently deployed stack. Fails if there is a diff.
diff:
	./manageAWS.sh diff

# COLORS for help recipe
GREEN  := $(shell tput -Txterm setaf 2)
YELLOW := $(shell tput -Txterm setaf 3)
WHITE  := $(shell tput -Txterm setaf 7)
RESET  := $(shell tput -Txterm sgr0)

# https://gist.github.com/prwhite/8168133#gistcomment-2278355
help:
	@echo ''
	@echo 'Usage:'
	@echo '  ${YELLOW}make${RESET} ${GREEN}<target>${RESET}'
	@echo ''
	@echo 'Targets:'
	@awk '/^[a-zA-Z\-\_0-9]+:/ { \
		helpMessage = match(lastLine, /^## (.*)/); \
		if (helpMessage) { \
			helpCommand = substr($$1, 0, index($$1, ":")-1); \
			helpMessage = substr(lastLine, RSTART + 3, RLENGTH); \
			printf "  ${YELLOW}%-$(TARGET_MAX_CHAR_NUM)s${RESET} ${GREEN}%s${RESET}\n", helpCommand, helpMessage; \
		} \
	} \
	{ lastLine = $$0 }' $(MAKEFILE_LIST)
