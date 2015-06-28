package com.craigburke

import asset.pipeline.AssetFile
import asset.pipeline.GenericAssetFile

import spock.lang.Specification
import spock.lang.Unroll

class JsClosureWrapProcessorSpec  extends Specification {
	
	@Unroll("Wrapping JS: #input")
	def "should wrap files with wrapped option"() {
		given:
		AssetFile assetFile = new GenericAssetFile(matchedDirectives: ['wrapped'])

		def processor = new JsClosureWrapProcessor()

		when:
		String result = processor.process(input, assetFile)
		
		then:
		result.startsWith('(function(){')
		result.contains(input)
		result.endsWith'})();'

		where:
		input << ["console.log('FOO');", "function(){ console.log('Closure within a closure? sure');}()"]
	}
	
	def "should not wrap files without wrapped option"() {
		given:
		AssetFile assetFile = new GenericAssetFile()
		def processor = new JsClosureWrapProcessor()

		when:
		String input = "console.log('unwrapped');"
		String result = processor.process(input, assetFile)

		then:
		result == input
	}
	

}
