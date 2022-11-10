import generatedantlr.Swift3BaseVisitor;
import generatedantlr.Swift3Parser;
import org.w3c.dom.ls.LSOutput;

import javax.json.JsonString;

public class SwiftToKotlinVisitor extends Swift3BaseVisitor<String> {

    @Override
    public String visitTop_level(Swift3Parser.Top_levelContext ctx) {
       String kotlinCode = visitStatements(ctx.statements());
       return kotlinCode;
    }

    @Override
    public String visitStatements(Swift3Parser.StatementsContext ctx) {
        String kotlinStatements = visitStatements_impl(ctx.statements_impl());
        return kotlinStatements;
    }


    @Override
    public String visitStatements_impl(Swift3Parser.Statements_implContext ctx) {
       String kotlinStatementImplementation = visitStatement(ctx.statement());
       return kotlinStatementImplementation;
    }

    //TODO: iterate over the statements list.
    @Override
    public String visitStatement(Swift3Parser.StatementContext ctx) {
        String kotlinStatement = visitDeclaration(ctx.declaration());
        return kotlinStatement;
    }


    @Override
    public String visitControl_transfer_statement(Swift3Parser.Control_transfer_statementContext ctx) {
        return "";
    }

    @Override
    public String visitReturn_statement(Swift3Parser.Return_statementContext ctx) {
        return "";
    }

    @Override
    public String visitLoop_statement(Swift3Parser.Loop_statementContext ctx) {
        return "";
    }

    @Override
    public String visitFor_in_statement(Swift3Parser.For_in_statementContext ctx) {
        return "";
    }

    @Override
    public String visitRepeat_while_statement(Swift3Parser.Repeat_while_statementContext ctx) {
        return "";
    }

    @Override
    public String visitCode_block(Swift3Parser.Code_blockContext ctx) {
        return "";
    }

    @Override
    public String visitWhile_statement(Swift3Parser.While_statementContext ctx) {
        return "";
    }

    @Override
    public String visitDeclaration(Swift3Parser.DeclarationContext ctx) {
        String kotlinDeclaration = visitVariable_declaration(ctx.variable_declaration());
        return kotlinDeclaration;
    }


    @Override
    public String visitStruct_declaration(Swift3Parser.Struct_declarationContext ctx) {
        return "";
    }

    @Override
    public String visitStruct_body(Swift3Parser.Struct_bodyContext ctx) {
        return "";
    }

    @Override
    public String visitStruct_member(Swift3Parser.Struct_memberContext ctx) {
        return "";
    }

    @Override
    public String visitInitializer_declaration(Swift3Parser.Initializer_declarationContext ctx) {
        return "";
    }



    @Override
    public String visitParameter_list(Swift3Parser.Parameter_listContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_declaration(Swift3Parser.Function_declarationContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_signature(Swift3Parser.Function_signatureContext ctx) {
        return "";
    }

    @Override
    public String visitConstant_declaration(Swift3Parser.Constant_declarationContext ctx) {
        return "";
    }

    @Override
    public String visitClass_declaration(Swift3Parser.Class_declarationContext ctx) {
        return "";
    }

    @Override
    public String visitClass_body(Swift3Parser.Class_bodyContext ctx) {
        return "";
    }

    @Override
    public String visitBranch_statement(Swift3Parser.Branch_statementContext ctx) {
        String kotlinCode ="";
        if(ctx.if_statement()!=null){
            kotlinCode+=visitIf_statement(ctx.if_statement());
        }else if(ctx.guard_statement()!=null){
            kotlinCode+=visitGuard_statement(ctx.guard_statement());
        }else if(ctx.switch_statement()!=null){
            kotlinCode+=visitSwitch_statement(ctx.switch_statement());
        }
        return kotlinCode;
    }
    @Override
    public String visitGuard_statement(Swift3Parser.Guard_statementContext ctx){
        return "";
    }

    @Override
    public String visitIf_statement(Swift3Parser.If_statementContext ctx) {
        String kotlinCode="";
        kotlinCode+="if";
        kotlinCode+=visitCondition_list(ctx.condition_list());
        kotlinCode+=visitCode_block(ctx.code_block());
        return kotlinCode;
    }
    @Override
    public String visitCondition_list(Swift3Parser.Condition_listContext ctx) {
        String kotlinCode ="";
        kotlinCode+=visitCondition((Swift3Parser.ConditionContext) ctx.condition());
        return kotlinCode;
    }


    @Override
    public String visitCondition(Swift3Parser.ConditionContext ctx) {
        String kotlinCode ="";
        kotlinCode+=visitExpression(ctx.expression());
        return kotlinCode;
    }

    @Override
    public String visitElse_clause(Swift3Parser.Else_clauseContext ctx) {
        return "";
    }
    @Override
    public String visitSwitch_statement(Swift3Parser.Switch_statementContext ctx) {
        return "";
    }

    @Override
    public String visitSwitch_cases(Swift3Parser.Switch_casesContext ctx) {
        return "";
    }

    @Override
    public String visitSwitch_case(Swift3Parser.Switch_caseContext ctx) {
        return "";
    }

    @Override
    public String visitVariable_declaration(Swift3Parser.Variable_declarationContext ctx) {
        String kotlinCode ="";
        kotlinCode += "var ";
        kotlinCode+= visitPattern_initializer_list(ctx.pattern_initializer_list());
        return kotlinCode;
    }

    @Override
    public String visitPattern_initializer_list(Swift3Parser.Pattern_initializer_listContext ctx) {
        String kotlinVariableInitializerList = "";
        for (int i = 0; i < ctx.pattern_initializer().size(); i++) {
            kotlinVariableInitializerList += visitPattern_initializer(ctx.pattern_initializer(i));
        }
        return kotlinVariableInitializerList;
    }

    //TODO: Redo this function.
    @Override
    public String visitPattern_initializer(Swift3Parser.Pattern_initializerContext ctx) {
        String kotlinPatternInitializer = visitPattern(ctx.pattern());
        if (ctx.initializer() == null)
            return kotlinPatternInitializer;

        return kotlinPatternInitializer + visitInitializer(ctx.initializer());
    }

    //TODO: convert the type annotation.
    @Override
    public String visitPattern(Swift3Parser.PatternContext ctx) {
        String kotlinPattern = visitIdentifier_pattern(ctx.identifier_pattern());
        return kotlinPattern;
    }


    @Override
    public String visitExpression_pattern(Swift3Parser.Expression_patternContext ctx) {
        return "";
    }

    @Override
    public String visitType_annotation(Swift3Parser.Type_annotationContext ctx) {
        return "";
    }

    @Override
    public String visitIdentifier_pattern(Swift3Parser.Identifier_patternContext ctx) {
        return ctx.getText();
    }

    //TODO:Redo this code
    @Override
    public String visitInitializer(Swift3Parser.InitializerContext ctx) {
        String kotlinInitializer = " ";
        System.out.println(ctx.getText());
        if (ctx.expression() != null){
            kotlinInitializer = visitExpression(ctx.expression());

        }
        System.out.println(kotlinInitializer);
//        return " = " + kotlinInitializer ;
        return ctx.getText();
    }

    @Override
    public String visitExpression(Swift3Parser.ExpressionContext ctx) {
        String kotlinPrefixExpression = visitPrefix_expression(ctx.prefix_expression());

        return kotlinPrefixExpression;
    }

    @Override
    public String visitBinary_expressions(Swift3Parser.Binary_expressionsContext ctx) {
        return "";
    }

    @Override
    public String visitBinary_expression(Swift3Parser.Binary_expressionContext ctx) {
        return "";
    }

    @Override
    public String visitPrefix_expression(Swift3Parser.Prefix_expressionContext ctx) {
        Swift3Parser.PrimaryContext pctx = (Swift3Parser.PrimaryContext) ctx.postfix_expression();
        String kotlinPrefixExpression = visitPrimary(pctx);

        return kotlinPrefixExpression;
    }

    @Override
    public String visitExplicit_member_expression2(Swift3Parser.Explicit_member_expression2Context ctx) {
        return "";
    }

    @Override
    public String visitPostfix_operation(Swift3Parser.Postfix_operationContext ctx) {

//        System.out.println(ctx.getChild(0) + " "+ ctx.getChild(1));
        return ctx.getChild(0) + " "+ ctx.getChild(1);
    }

    //TODO: work on the rest of the primary expression children.
    @Override
    public String visitPrimary(Swift3Parser.PrimaryContext ctx) {
        String kotlinCode ="";
        if(ctx.primary_expression().literal_expression()!=null){
            kotlinCode+=visitLiteral_expression(ctx.primary_expression().literal_expression());
        }else if(ctx.primary_expression().parenthesized_expression()!=null){
            kotlinCode+=visitParenthesized_expression(ctx.primary_expression().parenthesized_expression());
        }
        return kotlinCode;
    }

    @Override
    public String visitPrimary_expression(Swift3Parser.Primary_expressionContext ctx) {
        return "";
    }

    @Override
    public String visitClosure_expression(Swift3Parser.Closure_expressionContext ctx) {
        return "";
    }

    //TODO: implement this function.
    @Override
    public String visitLiteral_expression(Swift3Parser.Literal_expressionContext ctx) {
//        return ctx.literal().getText();
        return "";
    }
    @Override
    public String visitParenthesized_expression(Swift3Parser.Parenthesized_expressionContext ctx) {
        String kotlinCode="";
        kotlinCode+="(";
        kotlinCode+=visitExpression(ctx.expression());
        kotlinCode+=")";
        return kotlinCode;
    }

    @Override
    public String visitPostfix_operator(Swift3Parser.Postfix_operatorContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_call_argument_clause(Swift3Parser.Function_call_argument_clauseContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_call_argument_list(Swift3Parser.Function_call_argument_listContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_call_argument(Swift3Parser.Function_call_argumentContext ctx) {
        return "";
    }

    @Override
    public String visitFunction_call_expression_with_closure(Swift3Parser.Function_call_expression_with_closureContext ctx){
        return "";
    }
}
