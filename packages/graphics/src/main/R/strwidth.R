#  File src/library/graphics/R/strwidth.R
#  Part of the R package, http://www.R-project.org
#
#  This program is free software; you can redistribute it and/or modify
#  it under the terms of the GNU General Public License as published by
#  the Free Software Foundation; either version 2 of the License, or
#  (at your option) any later version.
#
#  This program is distributed in the hope that it will be useful,
#  but WITHOUT ANY WARRANTY; without even the implied warranty of
#  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#  GNU General Public License for more details.
#
#  A copy of the GNU General Public License is available at
#  http://www.r-project.org/Licenses/

strwidth <-
    function(s, units="user", cex=NULL, font = NULL, vfont = NULL,...)
{
    if (!is.null(vfont))
        vfont <- c(typeface = pmatch(vfont[1L], Hershey$typeface),
                   fontindex= pmatch(vfont[2L], Hershey$fontindex))
    warning("graphics are not yet implemented.")
}

strheight <-
    function(s, units="user", cex=NULL, font = NULL, vfont = NULL, ...)
{
    if (!is.null(vfont))
        vfont <- c(typeface = pmatch(vfont[1L], Hershey$typeface),
                   fontindex= pmatch(vfont[2L], Hershey$fontindex))
    warning("graphics are not yet implemented.")
}
