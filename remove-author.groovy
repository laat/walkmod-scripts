import org.walkmod.javalang.ast.body.JavadocComment;

for(type in node.types){
  if (type.getJavaDoc() != null) {
    def oldDoc = type.getJavaDoc().getContent()
    def newDoc = [];
    oldDoc.eachLine {
      if(!it.matches('^ \\* @author .*$')) {
        newDoc.add(it);
      }
    }
    if(!newDoc.join('').matches('^\\s$') ) {
      type.setJavaDoc(new JavadocComment(newDoc.join('\n')));
    } else {
      type.setJavaDoc(null);
    }
  }
}
