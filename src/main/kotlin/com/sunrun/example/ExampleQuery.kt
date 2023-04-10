package com.sunrun.example

import org.kie.kogito.rules.RuleUnitInstance
import org.kie.kogito.rules.RuleUnitQuery

class ExampleQuery(private val instance: RuleUnitInstance<NameOfRuleUnit>) :
    RuleUnitQuery<List<OutputObject>> {
    override fun execute(): List<OutputObject> {
        return instance.executeQuery("ExampleQuery").map { toResult(it) }
    }

    private fun toResult(tuple: Map<String, Any>): OutputObject {
        return tuple["\$outputObject"] as OutputObject
    }
}
