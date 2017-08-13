val codegenSettings = List(
  managedSources in Compile ++= {
    val out = sourceManaged.value / "foo.txt"
    IO.write(out, "Hello foo!")
    List(out)
  }
)
lazy val a = project.settings(
  inConfig(Test)(codegenSettings),
  inConfig(Compile)(codegenSettings)
)

