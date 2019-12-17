package org.laniakeamly.poseidon.framework.sql.builder;

import org.laniakeamly.poseidon.framework.tools.NewlineBuilder;
import org.laniakeamly.poseidon.framework.tools.StringNewline;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by 2BKeyboard on 2019/12/13 15:14
 */
public class ClassBuilder extends StringNewline implements CodeBuilderFactory{

    @Setter
    @Getter
    private String fullClassName;

    @Setter
    @Getter
    private String name;

    private int next = 0;

    private List<MethodBuilder> methods;
    private List<NewlineBuilder> varibale;

    public ClassBuilder(String name,String fullClassName){
        this.name = name;
        this.fullClassName = fullClassName.concat(name);
    }

    @Override
    public ClassBuilder methodToClassBody() {
        StringBuilder builder = new StringBuilder();
        for (MethodBuilder method : methods) {
            builder.append(method.toString(method.getArgs()));
        }
        insertLine(next,builder.toString());
        return this;
    }

    @Override
    public ClassBuilder createClassStatement() {
        appendLine("public class ".concat(name).concat(" {\n"));
        appendLine("}");
        return null;
    }

    @Override
    public ClassBuilder putMethod(MethodBuilder methodBuilder) {
        if(methods == null){
            methods = new ArrayList<>();
        }
        methods.add(methodBuilder);
        return this;
    }
}