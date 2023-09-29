cmake_minimum_required(VERSION 3.7)

project("Cypher-Parser-cpp")

set(THREADS_PREFER_PTHREAD_FLAG ON) 

list(APPEND CMAKE_MODULE_PATH ${CMAKE_CURRENT_SOURCE_DIR}/cmake)

# compiler must be at least 17
set(CMAKE_CXX_STANDARD 17)

# required if linking to static library
add_definitions(-DANTLR4CPP_STATIC)

# using /MD flag for antlr4_runtime (for Visual C++ compilers only)
set(ANTLR4_WITH_STATIC_CRT OFF)
# add external build for antlrcpp
include(ExternalAntlr4Cpp)
# add antrl4cpp artifacts to project environment
include_directories(${ANTLR4_INCLUDE_DIRS})

# set variable pointing to the antlr tool that supports C++
# this is not required if the jar file can be found under PATH environment
set(ANTLR_EXECUTABLE ${CMAKE_CURRENT_SOURCE_DIR}/tools/antlr-4.13.1-complete.jar)
# add macros to generate ANTLR Cpp code from grammar
find_package(ANTLR REQUIRED)

# Make sure to link against threads (pthreads) library in order to be able to
# make use of std::call_once in the code without producing runtime errors
# (see also https://github.com/antlr/antlr4/issues/3708 and/or https://stackoverflow.com/q/51584960).
find_package(Threads REQUIRED)
target_link_libraries(antlr4_shared INTERFACE Threads::Threads)
target_link_libraries(antlr4_static INTERFACE Threads::Threads)

# Call macro to add lexer and grammar to your build dependencies.
antlr_target( CypherGrammarParser Cypher.g4 VISITOR
              OUTPUT_DIRECTORY ${PROJECT_SOURCE_DIR}/libs/)

# add our project source directories
include_directories(${PROJECT_SOURCE_DIR}
					 ${PROJECT_SOURCE_DIR}/libs/)

add_executable(cypher-parser.exe main.cpp Visitor.cpp ${ANTLR_CypherGrammarParser_CXX_OUTPUTS})

# link required libraries
target_link_libraries(cypher-parser.exe antlr4_static ${SYSTEM_LIBS})

# copy the input file next to the generated executable
add_custom_command(TARGET cypher-parser.exe POST_BUILD
  COMMAND ${CMAKE_COMMAND} -E copy_if_different
  "${PROJECT_SOURCE_DIR}/input.cql"
  $<TARGET_FILE_DIR:cypher-parser.exe>)
