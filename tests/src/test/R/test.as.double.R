#
# Renjin : JVM-based interpreter for the R language for the statistical analysis
# Copyright © 2010-2016 BeDataDriven Groep B.V. and contributors
#
# This program is free software; you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation; either version 2 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program; if not, a copy is available at
# https://www.gnu.org/licenses/gpl-2.0.txt
#

# Generated by gen-unary-tests.R using GNU R version 3.2.0 (2015-04-16)
library(hamcrest)
as.double.foo <- function(...) 41
as.vector.foo <- function(...) 99
Math.bar <- function(...) 44
Summary.bar <- function(...) 45
Ops.bar <- function(...) 46
test.as.double.1 <- function() assertThat(as.double(NULL), identicalTo(numeric(0), tol = 0.000100))
test.as.double.2 <- function() assertThat(as.double(logical(0)), identicalTo(numeric(0), tol = 0.000100))
test.as.double.3 <- function() assertThat(as.double(c(TRUE, TRUE, FALSE, FALSE, TRUE)), identicalTo(c(1, 1, 0, 0, 1), tol = 0.000100))
test.as.double.4 <- function() assertThat(as.double(structure(c(TRUE, FALSE), .Names = c("a", ""))), identicalTo(c(1, 0), tol = 0.000100))
test.as.double.5 <- function() assertThat(as.double(c(TRUE, FALSE, NA)), identicalTo(c(1, 0, NA), tol = 0.000100))
test.as.double.6 <- function() assertThat(as.double(integer(0)), identicalTo(numeric(0), tol = 0.000100))
test.as.double.7 <- function() assertThat(as.double(structure(integer(0), .Names = character(0))), identicalTo(numeric(0), tol = 0.000100))
test.as.double.8 <- function() assertThat(as.double(1:3), identicalTo(c(1, 2, 3), tol = 0.000100))
test.as.double.9 <- function() assertThat(as.double(c(1L, NA, 4L, NA, 999L)), identicalTo(c(1, NA, 4, NA, 999), tol = 0.000100))
test.as.double.10 <- function() assertThat(as.double(c(1L, 2L, 1073741824L, 1073741824L)), identicalTo(c(1, 2, 1073741824, 1073741824), tol = 0.000100))
test.as.double.11 <- function() assertThat(as.double(numeric(0)), identicalTo(numeric(0), tol = 0.000100))
test.as.double.12 <- function() assertThat(as.double(c(3.14159, 6.28319, 9.42478, 12.5664, 15.708)), identicalTo(c(3.14159, 6.28319, 9.42478, 12.5664, 15.708), tol = 0.000100))
test.as.double.13 <- function() assertThat(as.double(c(-3.14159, -6.28319, -9.42478, -12.5664, -15.708)), identicalTo(c(-3.14159, -6.28319, -9.42478, -12.5664, -15.708), tol = 0.000100))
test.as.double.14 <- function() assertThat(as.double(structure(1:2, .Names = c("a", "b"))), identicalTo(c(1, 2), tol = 0.000100))
test.as.double.15 <- function() assertThat(as.double(structure(c(1.5, 2.5), .Names = c("a", "b"))), identicalTo(c(1.5, 2.5), tol = 0.000100))
test.as.double.16 <- function() assertThat(as.double(c(1.5, 1.51, 0, 1.49, -30)), identicalTo(c(1.5, 1.51, 0, 1.49, -30), tol = 0.000100))
test.as.double.17 <- function() assertThat(as.double(c(1.5, 1.51, 0, 1.49, -30, NA)), identicalTo(c(1.5, 1.51, 0, 1.49, -30, NA), tol = 0.000100))
test.as.double.18 <- function() assertThat(as.double(c(1.5, 1.51, 0, 1.49, -30, NaN)), identicalTo(c(1.5, 1.51, 0, 1.49, -30, NaN), tol = 0.000100))
test.as.double.19 <- function() assertThat(as.double(c(1.5, 1.51, 0, 1.49, -30, Inf)), identicalTo(c(1.5, 1.51, 0, 1.49, -30, Inf), tol = 0.000100))
test.as.double.20 <- function() assertThat(as.double(c(1.5, 1.51, 0, 1.49, -30, -Inf)), identicalTo(c(1.5, 1.51, 0, 1.49, -30, -Inf), tol = 0.000100))
test.as.double.21 <- function() assertThat(as.double(character(0)), identicalTo(numeric(0), tol = 0.000100))
test.as.double.22 <- function() assertThat(as.double(c("4.1", "blahh", "99.9", "-413", NA)), identicalTo(c(4.1, NA, 99.9, -413, NA), tol = 0.000100))
test.as.double.23 <- function() assertThat(as.double(list(1, 2, 3)), identicalTo(c(1, 2, 3), tol = 0.000100))
test.as.double.24 <- function() assertThat(as.double(list(1, 2, NULL)), throwsError())
test.as.double.25 <- function() assertThat(as.double(list(1L, 2L, 3L)), identicalTo(c(1, 2, 3), tol = 0.000100))
test.as.double.26 <- function() assertThat(as.double(list(1L, 2L, NULL)), throwsError())
test.as.double.27 <- function() assertThat(as.double(list(1, 2, list(3, 4))), throwsError())
test.as.double.28 <- function() assertThat(as.double(structure(1:12, .Dim = 3:4)), identicalTo(c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), tol = 0.000100))
test.as.double.29 <- function() assertThat(as.double(structure(1:12, .Dim = 3:4, .Dimnames = structure(list(    x = c("a", "b", "c"), y = c("d", "e", "f", "g")), .Names = c("x", "y")))), identicalTo(c(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), tol = 0.000100))
test.as.double.30 <- function() assertThat(as.double(structure(1:3, rando.attrib = 941L)), identicalTo(c(1, 2, 3), tol = 0.000100))
test.as.double.31 <- function() assertThat(as.double(structure(1:3, .Dim = 3L, .Dimnames = list(c("a", "b", "c")))), identicalTo(c(1, 2, 3), tol = 0.000100))
test.as.double.32 <- function() assertThat(as.double(structure(list("foo"), class = "foo")), identicalTo(41, tol = 0.000100))
test.as.double.33 <- function() assertThat(as.double(structure(list("bar"), class = "foo")), identicalTo(41, tol = 0.000100))
test.as.double.34 <- function() assertThat(as.double(quote(xyz)), throwsError())
test.as.double.35 <- function() assertThat(as.double(quote(sin(3.14))), throwsError())
test.as.double.36 <- function() assertThat(as.double(structure("foo", class = "foo")), identicalTo(41))
test.as.double.37 <- function() assertThat(as.double(structure(list(1L, "bar"), class = "bar")), identicalTo(c(1, NA)))
