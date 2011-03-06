/* sbt -- Simple Build Tool
 * Copyright  2010 Mark Harrah
 */
package object sbt extends sbt.std.TaskExtra with sbt.Types with sbt.ProcessExtra with sbt.impl.DependencyBuilders with sbt.PathExtra with sbt.ProjectConstructors
{
	type Setting[T] = Project.Setting[T]
	type ScopedKey[T] = Project.ScopedKey[T]
	type File = java.io.File
	type URI = java.net.URI
	implicit def maybeToOption[S](m: xsbti.Maybe[S]): Option[S] =
		if(m.isDefined) Some(m.get) else None
	def uri(s: String): URI = new URI(s)
	def file(s: String): File = new File(s)
	
		import sbt.{Configurations => C}
	def Compile = C.Compile
	def Test = C.Test
	def Runtime = C.Runtime
	def IntegrationTest = C.IntegrationTest
	def Default = C.Default
	def Javadoc = C.Javadoc
	def Sources = C.Sources
	def Provided = C.Provided
// java.lang.System is more important, so don't alias this one
//	def System = C.System
	def Optional = C.Optional

	implicit def globFilter(expression: String): NameFilter = GlobFilter(expression)
}
