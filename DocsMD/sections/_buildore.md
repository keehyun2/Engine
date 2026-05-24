# Getting and Building ORE

ORE’s source code is hosted at
<https://github.com/opensourcerisk/engine>.

You can get ORE sources in two ways, either by downloading a release
bundle as described in section
<a href="#sec:release" data-reference-type="ref"
data-reference="sec:release">1.1</a> or by checking out the source code
from the github repository as described in section
<a href="#sec:build_ore" data-reference-type="ref"
data-reference="sec:build_ore">1.2</a>. In both cases, the user usually
needs to build (compile) from sources in a platform dependent way. To
avoid that build process, one can either get the pre-built ORE Python
module as mentioned in section
<a href="#sec:intro_wheels" data-reference-type="ref"
data-reference="sec:intro_wheels">[sec:intro_wheels]</a>, or try the
executables built on github automatically for a few platforms for
testing purposes, see the “Actions” menu.

## ORE Releases

ORE releases are snapshots of the ORE codebase, regularly provided in
the form of source code archives. These archives are provided at
<https://github.com/opensourcerisk/engine/releases> under the “Assets”
heading for each release, accessible via the download links

-  (zip) and

-  (tar.gz)

Additional “assets” include pdf documentation for convenience (built
from tex sources in the release) such as user guide, product and
methodology catalogue, or the scripted trade guide.

Unpacking the downloaded release archive creates a directory
`Engine-<VERSION>` (because the repository is called Engine - feel free
to rename this to “ore” after unpacking) with the following files resp.
subdirectories

1.  `App/`

2.  `cmake/`

3.  `CMakeLists.txt`

4.  `CMakePresets.json`

5.  `cmake/`

6.  `Docker/`

7.  `Docs/`

8.  `Examples/`

9.  `FrontEnd/`

10. `OREAnalytics/`

11. `OREData/`

12. `ORETest/`

13. `ORE-SWIG/`

14. `QuantExt/`

15. `QuantLib/`

16. `ThirdPartyLibs/`

17. `Tools/`

18. `Tutorials/`

19. `xsd/`

Note:

- Each release also contains the QuantLib source version that ORE
  depends on; this is usually the latest QuantLib release that precedes
  the ORE release including a small number of patches.

- Since release 13 ORE-SWIG sources are included in the Engine
  repository, and ORE-SWIG contains QuantLib-SWIG

## Access via Git

To access the evolving code base on GitHub or specific versions
conveniently, one should clone ORE’s git repository.

1.  Install Git on your machine following instructions at

2.  Fetch ORE from github by running the following:

    `% git clone https://github.com/opensourcerisk/engine.git ore`

    This will create a folder ‘ore’ in your current directory that
    contains the codebase.

3.  Initially, the QuantLib subdirectory under `ore` is empty as it is a
    submodule pointing to the official QuantLib repository. To pull down
    locally, use the following commands:

    ` % cd ore`  
    `% git submodule init`  
    `% git submodule update `

Note that one can also run

`% git clone --recurse-submodules https://github.com/opensourcerisk/engine.git ore`

in step 2, which also performs the steps in 3.

The above fetches ORE from the master branch, if you want to fetch a
specific release then right after `% cd ore` do
`% git checkout tags/release_name`, e.g.
`% git checkout tags/v1.8.12.0`.

## Prerequisites for Building ORE

To build ORE from sources one needs to install the following collection
of tools

- C++ compiler

- Boost libraries

- CMake

- Ninja (optional)

- zlib (optional)

- Eigen

- Swig

- Python

where the latter two are required to build the ORE Python module.

### C++ Compiler

QuantLib and ORE are written in C++, so we need a C++ compiler – this
comes on Windows with Visual Studio, it is gcc on Linux, clang on macOS.

On Windows, download and install Visual Studio Community Edition
(Version 2019 or later, 2022 is recommended), and during the
installation, make sure to

- install the Visual C++ support under the Programming Languages
  features (disabled by default)

- install the feature ’C++ CMake Tools for Windows’

### CMake

The ORE build requires CMake (<https://cmake.org>), to be installed on
Linux and macOS using the usual package managers (apt, homebrew). Visual
Studio has CMake support in VS2019 or later, and you can install the
feature ’C++ CMake Tools for Windows’ with VS instead of installing
CMake as standalone program on Windows.

### Boost

QuantLib and ORE depend on the Boost C++ libraries, to be installed
before kicking off the build process. At least Boost version 1.75.0 is
required.

On Linux and macOS, one can install boost conveniently using apt or
homebrew

`sudo apt install libboost-all-dev`  
`brew install boost`  
Otherwise, when building boost following instructions at and when
installing boost in a non-standard path, take note of the boost include
and library directories on your system. These paths need to be passed to
the CMake configure step, see below.

On Windows:

1.  Download the pre-compiled binaries for your MSVC version (e.g.
    MSVC-14.3 for MSVC2022) from

    - 32-bit: VERSIONboost_VERSION-msvc-14.3-32.exedownload

    - 64-bit: VERSIONboost_VERSION-msvc-14.3-64.exedownload

2.  Start the installation file and choose an installation folder (the
    “boost root directory”). Take a note of that folder as it will be
    needed later on.

3.  Finish the installation by clicking Next a couple of times.

Alternatively, compile all Boost libraries directly from the source
code:

1.  Open a Visual Studio Tools Command Prompt

    - 32-bit: VS2022 x86 Native Tools Command Prompt

    - 64-bit: VS2022 x64 Native Tools Command Prompt

2.  Navigate to the boost root directory

3.  Run bootstrap.bat

4.  Build the libraries from the source code

    - 32-bit:  
      `.b2 --stagedir=.libWin32lib --build-type=complete toolset=msvc-14.3`  
      `address-model=32 --with-test --with-system --with-filesystem`  
      `--with-serialization --with-regex --with-date_time stage`

    - 64-bit:  
      `.b2 --stagedir=.libx64lib --build-type=complete toolset=msvc-14.3`  
      `address-model=64 --with-test --with-system --with-filesystem`  
      `--with-serialization --with-regex --with-date_time stage`

Configure boost paths, setting environment variables, e.g.:

- `%BOOST%` pointing to your directory, e.g, `C:boost_1_72_0`

- `%BOOST_LIB32%` pointing to your Win32 lib directory, e.g,
  `C:boost_1_72_0lib32msvc`

- `%BOOST_LIB64%` pointing to your x64 lib directory, e.g,
  `C:boost_1_72_0lib64msvc`

### Compiler / Boost Versions

Ensure consistency of compiler and boost version: The following table
<a href="#tab:compiler_boost_versions" data-reference-type="ref"
data-reference="tab:compiler_boost_versions">1</a> reflects the compiler
/ boost version combinations that the users/developers at
Quaternion/Acadia/LSEG can confirm as working combinations with the
latest ORE v13.

<div id="tab:compiler_boost_versions">

| Compiler                  | Boost  | ORE |
|:--------------------------|:------:|:---:|
| AppleClang version 15.0.0 | 1.83.0 | 13  |
| AppleClang version 15.0.0 | 1.86.0 | 13  |
| AppleClang version 15.0.0 | 1.88.0 | 13  |
| clang 19.1.7              | 1.83.0 | 13  |
| VS2022                    | 1.86.0 | 13  |

Supported compiler and boost versions for ORE v13, every boost version
between 1.72. and 1.86 should work on Windows.

</div>

### Ninja

The installation of Ninja is optional.

When running the build process in the command line on a Linux or macOS
system, the default “generator” is `GNU make` which is expected to be
available on the system. As an alternative and for build speed we
recommend `Ninja` (<https://ninja-build.org>). Moreover, Ninja is also
available on Windows, so that we can run command line builds with same
commands on Windows, Linux and macOS.

However, Windows users can rely on Visual Studio’s collaboration with
CMake (see below) without additional generator.

### zlib

ORE can use zlib for writing compressed data, to be installed on Linux
or macOS using the usual package manager. It can be installed on Windows
with the open source c++ library manager VCPKG. To get VCPG, see
<https://vcpkg.io/en/getting-started.html>. And to install ZLIB with
VCPKG:

`vcpkg install --triplet x64-windows zlib`  
To make VCPKG visible to CMake, create an environment variable
`VCPKG_ROOT` pointing to the root of the vcpkg directory and configure
ORE with the flag

`-DCMAKE_TOOLCHAIN_FILE=%VCPKG_ROOT%/scripts/buildsystems/vcpkg.cmake`.  
To use VCPKG with Visual Studio add the toolChainFile to the
configurePresets in the CMakePresets.json:

`"toolchainFile": "$env{VCPKG_ROOT}/scripts/buildsystems/vcpkg.cmake",`  
To enable ZLIB support in ORE, configure CMake with the flag
`-DORE_USE_ZLIB=ON`.

### Eigen

ORE requires the Eigen libraries (<https://gitlab.com/libeigen/eigen>)
for some Credit Risk analytics. On Windows, one can conveniently install
using VCPKG with:

`vcpkg install --triplet x64-windows eigen3`

### Swig and Python

Finally, to also build the ORE Python module from sources, install
`swig` (<https://swig.org>) and Python (version 3.5 or higher). The
latter is also required to run the examples in section
<a href="#sec:examples" data-reference-type="ref"
data-reference="sec:examples">[sec:examples]</a> or to use the pre-built
ORE Python module in section
<a href="#example:orepython" data-reference-type="ref"
data-reference="example:orepython">[example:orepython]</a>.

## Building ORE

ORE uses the CMake build system with the following essential parameters
(see ore/CMakeLists.txt, ore/QuantExt/CMakeLists.txt,
ore/QuantLib/CMakeLists.txt) which affect the build:

| Option                                 | Description                                                                                     | Default                             |
|:---------------------------------------|:------------------------------------------------------------------------------------------------|:------------------------------------|
| ORE_BUILD_DOC                          | Build PDF documentation                                                                         | ON                                  |
| ORE_BUILD_EXAMPLES                     | Build examples                                                                                  | ON                                  |
| ORE_BUILD_TESTS                        | Build test suites                                                                               | ON                                  |
| ORE_BUILD_APP                          | Build the ORE commandline application `ore[.exe]`                                               | ON                                  |
| ORE_BUILD_SWIG                         | Build the ORE Python module                                                                     | ON                                  |
| ORE_ENABLE_OPENCL                      | Build the compute environment using OpenCL, to utilise a GPU                                    | OFF                                 |
| ORE_ENABLE_CUDA                        | Build the compute environment using CUDA, to utilise a GPU                                      | OFF                                 |
| ORE_PYTHON_INTEGRATION                 | Build ORE with Python Integration, allows calling from C++ into Python                          | OFF                                 |
| ORE_USE_ZLIB                           | Use compression for boost::iostreams, e.g. to write compressed cube files                       | OFF                                 |
| ORE_MULTITHREADING \_CPU_AFFINITY      | Set cpu affinitity in multithreaded calculations                                                | OFF                                 |
| ORE_ENABLE_PARALLEL \_UNIT_TEST_RUNNER | Enable the parallel unit test runner                                                            | OFF                                 |
| MSVC_LINK_DYNAMIC_RUNTIME              | Link against dynamic runtime                                                                    | ON                                  |
| MSVC_PARALLELBUILD                     | Use flag /MP                                                                                    | ON                                  |
| QL_USE_PCH                             | Use precompiled headers                                                                         | OFF                                 |
| QL_ENABLE_SESSIONS                     | Singletons return different instances for different sessions; turn ON for ORE’s multi-threading | OFF                                 |
| QL_BUILD_EXAMPLES                      | Build QuantLib examples                                                                         | ON                                  |
| QL_BUILD_TEST_SUITE                    | Build QuantLib test suite                                                                       | ON                                  |
| BOOST_INCLUDEDIR, BOOST_ROOT           | directory containing the “boost” folder, root of all boost includes                             | user-provided if not found by CMake |
| BOOST_LIBRARYDIR                       | folder containing compiled boost libraries                                                      | user-provided if not found by CMake |
| Python_ROOT                            | directory containing Python.h                                                                   | user-provided if not found by CMake |
| Python_LIBRARY                         | Python shared library name including full path                                                  | user-provided if not found by CMake |

The latter BOOST and Python variables have been added to the list,
because CMake may use them to locate the BOOST and Python development
files, if CMake does not find them automatically.

### Linux and macOS

To run CMake we first create a directory `build` in the ORE root
directory, and change to `build`.

The CMake build system is then configured by calling `cmake` in the
command line with a series of command line parameters `-D` which allow
overriding/setting the essential parameters listed above:

  
`-D QL_ENABLE_SESSIONS=ON `  
`-D QL_BUILD_EXAMPLES=OFF `  
`-D ORE_USE_ZLIB=ON `  
`[ -D BOOST_INCLUDEDIR=<path/to/boost/includes>  ] `  
`[ -D BOOST_LIBRARYDIR=<path/to/boost/libraries>  ] `  
`[ -D Python_ROOT=<directory containing Python.h>  ] `  
`[ -D Python_LIBRARY=<path/to/PythonLibrary>  ] `  
`[ -G Ninja ] `

Then build ORE with calling `make` or `ninja` depending on the
configuration above.

The default CMake build includes the ORE Python module already (since
`ORE_BUILD_SWIG = ON` by default) which can be used to run ORE Python
locally as shown in section
<a href="#example:orepython" data-reference-type="ref"
data-reference="example:orepython">[example:orepython]</a>. There are
alternative ways of building ORE Python, in particular building Python
wheels for distribution. Section
<a href="#sec:oreswig" data-reference-type="ref"
data-reference="sec:oreswig">1.5</a> points to related tutorials.

### Windows

Visual Studio 2019 and later supports CMake Projects.

1.  Start Visual Studio 2019 or later.

2.  Select “Open a local folder” from the start page or menu.

3.  In the dialog window, select the ORE root directory.

4.  Visual Studio will read the cmake presets from CMakePresets.json and
    the project file CMakeList.txt and configure the project.

5.  Once the configuration is finished and one can build the project.

6.  The executables are built in the subfolder
    `/build/TARGET/CONFIGURATION/EXECUTABLE`, e.g.
    `/build/App/Release/ore.exe`.

ORE is shipped with configuration and build presets using Visual Studio
2022 and the Ninja build system. Those presets are configured in the
CMakePreset.json which is read by Visual Studio by default when opening
the CMake project. If you want to use Visual Studio 2019 instead, you
would have to change the Generator in the CMakePreset.json from "Visual
Studio 17 2022" to "Visual Studio 16 2019".

You can switch in the solution explorer from the file view to the
projects view, where the CMake Targets View can be selected. In this
view, the various target projects can be seen below “ORE Project” and be
used in a similar manner as the usual VS projects.

Alternatively, Visual Studio project files can be auto-generated from
the CMake project files or ORE can be built with the CMake command line
tool, similar to UNIX / Mac systems.

1.  Generate MSVC project files from CMake files:

    - Open a Visual Studio Tools Command Prompt

      - 32-bit: VS2022/x86 Native Tools Command Prompt for VS 2022

      - 64-bit: VS2022/x64 Native Tools Command Prompt for VS 2022

    - Navigate to the ORE root directory

    - Run CMake command:

      - 64-bit:  
        `cmake -G "Visual Studio 17 2022" -A x64 -DBOOST_INCLUDEDIR=%BOOST% -DBOOST_LIBRARYDIR=%BOOST_LIB64% -DQL_ENABLE_SESSIONS=ON -DMSVC_LINK_DYNAMIC_RUNTIME=true -B build`

      - 32-bit:  
        `cmake -G "Visual Studio 17 2022" -A x32 -DBOOST_INCLUDEDIR=%BOOST% -DBOOST_LIBRARYDIR=%BOOST_LIB32% -DQL_ENABLE_SESSIONS=ON -DMSVC_LINK_DYNAMIC_RUNTIME=true -B build`

      Replace the generator "Visual Studio 17 2022" with the actual
      installed version. The solution and project files will be
      generated in the $\langle$`ORE_ROOT`$\rangle$`build` subdirectory.

2.  build the cmake project with the command
    `cmake --build build -v --config Release`,

3.  or open the MSVC solution file `buildORE.sln` and build the entire
    solution with Visual Studio (again, make sure to select the correct
    platform in the configuration manager first).

## Building ORE Python Wheels

The ORE Python module is part of the CMake build process by default, see
above.

However, to build Python wheels (modules for distribution) we use
Python’s setup.py approach. See the tutorials at
<https://github.com/OpenSourceRisk/Engine/blob/master/tutorials_index.md>.

The wheels for various platforms and Python versions that get
distributed via <https://pypi.org> (so that users can do a “pip install
open-source-risk-engine”) are built on github using github workflows,
see ore/.github/workflows and related actions).

Typical usage of the Python module is shown in ORE’s
`Examples/ORE-Python` directory and described in user guide section
<a href="#example:orepython" data-reference-type="ref"
data-reference="example:orepython">[example:orepython]</a>.

## ORE with Python Integration

This section describes a new (still experimental) feature of ORE that
supports calls from ORE into Python in order to utilise some
functionality that is readily available in Python so that we can avoid
its implementation in C++ in “core ORE”, e.g. for testing purposes. An
example is the use of regression methods provided in the `scikit-learn`
and `py-earth2` Python modules, as demonstrated in Example/InitialMargin
where we have provided an option to utilise such methods embedded into
American Monte Carlo as alternatives for the usual polynomial regression
provided by QuantLib.

Prerequisites for using this functionality are

- building ORE with the `ORE_PYTHON_INTEGRATION` switch set to `ON`, see
  section <a href="#sec:build" data-reference-type="ref"
  data-reference="sec:build">1.4</a>;

- specifying the `Python_ROOT` and `Python_LIBRARY` variables when
  calling `cmake` so that cmake finds the Python installation on your
  system, as in the case of building Python wheels
  <a href="#sec:oreswig" data-reference-type="ref"
  data-reference="sec:oreswig">1.5</a>;

- extending the `PYTHONPATH` environment variable to contain directory
  `ore/PythonIntegration` where ORE will be looking for the script
  `ore_python_integration.py` that contains the Python functions that
  can be called from the C++ side of ORE.

See the Jupyter notebook Examples/InitialMargin/ore_dynamicsimm.ipynb
for a demonstration of this new feature.
