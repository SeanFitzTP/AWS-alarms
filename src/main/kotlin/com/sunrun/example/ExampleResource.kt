package com.sunrun.example

import kotlinx.serialization.Serializable
import org.kie.kogito.rules.DataSource
import org.kie.kogito.rules.RuleUnitData
import org.kie.kogito.rules.SingletonStore
import java.math.BigDecimal

// todo rename this class
// this class needs to be specified in the decision table under Unit
data class NameOfRuleUnit(
    // this is your input object.
    // If you use SingletonStore, it will return only a single result in the generated endpoints
    // If you use a DataStore, multiple results can be returned.
    // todo rename the input object, according to what you want your json payload to be
    /**
     * `inputObject` will result in {"inputObject": <InputObject>} as the key/value
     */
    val inputObject: SingletonStore<InputObject>,
    // output object, same rules apply
    // todo rename the output object,
    /**
     * `outputObject` will result in {"outputObject": <OutputObject>} as the key/value
     */
    val outputObject: SingletonStore<OutputObject>
) : RuleUnitData {
    // we need to create an input and output object to begin.
    // either DataSource#createSingleton for SingletonSource or
    // DataSource#createStore for DataStore
    constructor() : this(DataSource.createSingleton<InputObject>(), DataSource.createSingleton<OutputObject>())
}

// note you must use var if you are going to set the values in the decision table
@Serializable
data class NestedObject(
    var string1: String? = null,
    var string2: String? = null,
    var string3: String? = null
)

// note nested objects must either be set as a default here, or created in the decision
//   table. It's much easier to set it here.
@Serializable
data class OutputObject(
    var integer: Int? = null,
    var string: String? = null,
    var nestedObject: NestedObject = NestedObject()
)

@Serializable
data class InputObject(
    val integer: Int,
    val string: String,
    val enum: ExampleEnum,
    val enumWithValues: ExampleEnumWithValues
)

enum class ExampleEnum { A, B, C }

enum class ExampleEnumWithValues(val bookName: String) {
    HHGTTG("The Hitchhiker's Guide to the Galaxy"),
    TRATEOTU("The Restaurant at the End of the Universe"),
    LTUE("Life, the Universe and Everything"),
    SLATFATF("So Long, and Thanks for All the Fish"),
    MH("Mostly Harmless"),
    AAT("And Another Thing...");

    companion object {
        fun valueOfByCode(bookName: String) = values().first { it.bookName == bookName }
    }
}

fun exampleFunctionToImportIntoDecisionTable() {}

@Serializable
data class ExampleResponse(
    val version: String = "",
    val outputObjects: List<OutputObject> = listOf()
)
