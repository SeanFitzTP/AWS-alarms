package com.sunrun.example

import com.sunrun.example.helpers.aws.getLambdaVersion
import org.kie.kogito.rules.units.FieldDataStore
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

/**
 * Receives the request, sets the input/output objects and calls the rule engine
 *
 * Based on the discussion https://kie.zulipchat.com/#narrow/stream/232677-drools/topic/Match.20on.20the.20most.20strictest.20rules.20and.20not.20more.20general.20ones
 * there's no inherent way of fetching only the most specific rules.
 *
 * As a consequence, we need to apply that after we have the results.
 * applyMostSpecificRulesOnly handles that work.
 *
 */
@ApplicationScoped
class ExampleWrapper {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Inject
    lateinit var resource: ExampleQueryEndpoint


    fun handleRequest(request: InputObject): ExampleResponse {
        val inputObject = FieldDataStore<InputObject>().apply {
            set(request)
        }
        val outputObject = FieldDataStore<OutputObject>()
        val ruleUnitObject = NameOfRuleUnit(inputObject, outputObject)
        val matches = resource.executeQuery(ruleUnitObject)

        return ExampleResponse(getLambdaVersion(), matches)
    }
}
