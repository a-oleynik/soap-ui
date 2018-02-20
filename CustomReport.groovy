def failedTestCases = 0
def successTestCases = 0
def failedTestSteps = 0
def successTestSteps = 0
def failedAssertions = 0
def successAssertions = 0

for( testCaseResult in runner.results)
{
	def caseStatus = testCaseResult.status.toString()
     if(caseStatus == 'FAILED'){failedTestCases ++}
     else {successTestCases ++}
	testCaseName = testCaseResult.getTestCase().name
     log.info "Test Case: $testCaseName $caseStatus"
	for ( testStepResult in testCaseResult.getResults()  )
	{
		testStepResult.messages.each() { msg -> log.info "Test message: \"$msg\""}
		def stepName = testStepResult.testStep.name
          def stepStatus =  testStepResult.getStatus()
          if(stepStatus == 'FAILED'){failedTestSteps ++}
          else{successTestSteps ++}
          log.info "Test Step: $stepName $stepStatus"
          
          if (testStepResult.testStep.config.type.contains('request'))
          {
            testStepResult.testStep.getAssertionList().each{
                def assertLabel = it.label
                def assertStatus = it.status.toString()
                if (assertStatus == 'VALID') { successAssertions ++ }
                else {failedAssertions ++ }
                    log.info "$it.label - $it.status"   
            }
          }
	}
}

log.info "Total test case count:" + (successTestCases + failedTestCases).toString()
log.info "Total test cases succeeded: $successTestCases"
log.info "Total test cases failed: $failedTestCases"

log.info "Total test step count:" + (successTestSteps + failedTestSteps).toString()
log.info "Total test steps succeeded: $successTestSteps"
log.info "Total test steps failed: $failedTestSteps"

log.info "Total test assertion count:" + (successAssertions + failedAssertions).toString()
log.info "Total test assertions succeeded: $successAssertions"
log.info "Total test assertions failed: $failedAssertions"
