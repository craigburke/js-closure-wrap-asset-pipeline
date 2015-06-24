package com.craigburke

import asset.pipeline.AssetFile
import asset.pipeline.GenericAssetFile

import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class JsClosureWrapProcessorSpec  extends Specification {

    @Shared
    AssetFile assetFile

    def setup() {
        assetFile = new GenericAssetFile(path: 'foo/bar.js')
    }
	
	@Unroll("Wrapping JS: #input")
	def "process HTML input"() {
    	given:
        def processor = new JsClosureWrapProcessor()

		expect:
		String result = processor.process(input, assetFile)
		result.startsWith('(function(){')
		result.contains(input)
		result.endsWith'})();'
		
        where:
        input << ["console.log('FOO');", "function(){ console.log('Closure within a closure? sure');}()"]
	}
	
}