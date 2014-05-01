package util

class BeanUtils {

	static def copyProperties(def source, def target){
		target.metaClass.properties.each{
		   if (source.metaClass.hasProperty(source, it.name) && it.name != 'metaClass' && it.name != 'class')
			  it.setProperty(target, source.metaClass.getProperty(source, it.name))
		}
	 }
}
