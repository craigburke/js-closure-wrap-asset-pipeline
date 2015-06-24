package com.craigburke;

import asset.pipeline.AssetCompiler;
import asset.pipeline.AssetPipelineConfigHolder;
import asset.pipeline.AssetFile;

public class JsClosureWrapProcessor {
	
	public JsClosureWrapProcessor(AssetCompiler precompiler) {}
		
	public String process(String input, AssetFile assetFile) {
		return "(function(){\n" + input + "\n})();";
	}

}