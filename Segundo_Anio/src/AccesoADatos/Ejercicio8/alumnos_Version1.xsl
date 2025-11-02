<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
        <title>Lista de Alumnos</title>
      </head>
      <body>
        <h2>Listado de Alumnos</h2>
        <table border="1">
          <tr>
            <th>NIA</th>
            <th>Nombre</th>
            <th>Apellidos</th>
            <th>Ciclo</th>
            <th>Curso</th>
            <th>Grupo</th>
            <th>Género</th>
            <th>Fecha de Nacimiento</th>
          </tr>
          <xsl:for-each select="Alumnos/Alumno">
            <tr>
              <td><xsl:value-of select="Nia"/></td>
              <td><xsl:value-of select="Nombre"/></td>
              <td><xsl:value-of select="Apellidos"/></td>
              <td><xsl:value-of select="Ciclo"/></td>
              <td><xsl:value-of select="Curso"/></td>
              <td><xsl:value-of select="Grupo"/></td>
              <td><xsl:value-of select="Genero"/></td>
              <td><xsl:value-of select="Fecha_Nacimiento"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>