
// Generated from Cypher.g4 by ANTLR 4.13.0

#pragma once


#include "antlr4-runtime.h"
#include "CypherVisitor.h"


/**
 * This class provides an empty implementation of CypherVisitor, which can be
 * extended to create a visitor which only needs to handle a subset of the available methods.
 */
class  CypherBaseVisitor : public CypherVisitor {
public:

  virtual std::any visitOC_Cypher(CypherParser::OC_CypherContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Statement(CypherParser::OC_StatementContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Query(CypherParser::OC_QueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RegularQuery(CypherParser::OC_RegularQueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Union(CypherParser::OC_UnionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SingleQuery(CypherParser::OC_SingleQueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SinglePartQuery(CypherParser::OC_SinglePartQueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_MultiPartQuery(CypherParser::OC_MultiPartQueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_UpdatingClause(CypherParser::OC_UpdatingClauseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ReadingClause(CypherParser::OC_ReadingClauseContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Match(CypherParser::OC_MatchContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Unwind(CypherParser::OC_UnwindContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Merge(CypherParser::OC_MergeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_MergeAction(CypherParser::OC_MergeActionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Create(CypherParser::OC_CreateContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Set(CypherParser::OC_SetContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SetItem(CypherParser::OC_SetItemContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Delete(CypherParser::OC_DeleteContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Remove(CypherParser::OC_RemoveContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RemoveItem(CypherParser::OC_RemoveItemContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_InQueryCall(CypherParser::OC_InQueryCallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_StandaloneCall(CypherParser::OC_StandaloneCallContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_YieldItems(CypherParser::OC_YieldItemsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_YieldItem(CypherParser::OC_YieldItemContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_With(CypherParser::OC_WithContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Return(CypherParser::OC_ReturnContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ProjectionBody(CypherParser::OC_ProjectionBodyContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ProjectionItems(CypherParser::OC_ProjectionItemsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ProjectionItem(CypherParser::OC_ProjectionItemContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Order(CypherParser::OC_OrderContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Skip(CypherParser::OC_SkipContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Limit(CypherParser::OC_LimitContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SortItem(CypherParser::OC_SortItemContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Where(CypherParser::OC_WhereContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Pattern(CypherParser::OC_PatternContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PatternPart(CypherParser::OC_PatternPartContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_AnonymousPatternPart(CypherParser::OC_AnonymousPatternPartContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PatternElement(CypherParser::OC_PatternElementContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RelationshipsPattern(CypherParser::OC_RelationshipsPatternContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NodePattern(CypherParser::OC_NodePatternContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PatternElementChain(CypherParser::OC_PatternElementChainContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RelationshipPattern(CypherParser::OC_RelationshipPatternContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RelationshipDetail(CypherParser::OC_RelationshipDetailContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Properties(CypherParser::OC_PropertiesContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RelationshipTypes(CypherParser::OC_RelationshipTypesContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NodeLabels(CypherParser::OC_NodeLabelsContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NodeLabel(CypherParser::OC_NodeLabelContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RangeLiteral(CypherParser::OC_RangeLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_LabelName(CypherParser::OC_LabelNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RelTypeName(CypherParser::OC_RelTypeNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PropertyExpression(CypherParser::OC_PropertyExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Expression(CypherParser::OC_ExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_OrExpression(CypherParser::OC_OrExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_XorExpression(CypherParser::OC_XorExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_AndExpression(CypherParser::OC_AndExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NotExpression(CypherParser::OC_NotExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ComparisonExpression(CypherParser::OC_ComparisonExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PartialComparisonExpression(CypherParser::OC_PartialComparisonExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_StringListNullPredicateExpression(CypherParser::OC_StringListNullPredicateExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_StringPredicateExpression(CypherParser::OC_StringPredicateExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ListPredicateExpression(CypherParser::OC_ListPredicateExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NullPredicateExpression(CypherParser::OC_NullPredicateExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_AddOrSubtractExpression(CypherParser::OC_AddOrSubtractExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_MultiplyDivideModuloExpression(CypherParser::OC_MultiplyDivideModuloExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PowerOfExpression(CypherParser::OC_PowerOfExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_UnaryAddOrSubtractExpression(CypherParser::OC_UnaryAddOrSubtractExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NonArithmeticOperatorExpression(CypherParser::OC_NonArithmeticOperatorExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ListOperatorExpression(CypherParser::OC_ListOperatorExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PropertyLookup(CypherParser::OC_PropertyLookupContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Atom(CypherParser::OC_AtomContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_CaseExpression(CypherParser::OC_CaseExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_CaseAlternative(CypherParser::OC_CaseAlternativeContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ListComprehension(CypherParser::OC_ListComprehensionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PatternComprehension(CypherParser::OC_PatternComprehensionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Quantifier(CypherParser::OC_QuantifierContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_FilterExpression(CypherParser::OC_FilterExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PatternPredicate(CypherParser::OC_PatternPredicateContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ParenthesizedExpression(CypherParser::OC_ParenthesizedExpressionContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_IdInColl(CypherParser::OC_IdInCollContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_FunctionInvocation(CypherParser::OC_FunctionInvocationContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_FunctionName(CypherParser::OC_FunctionNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ExistentialSubquery(CypherParser::OC_ExistentialSubqueryContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ExplicitProcedureInvocation(CypherParser::OC_ExplicitProcedureInvocationContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ImplicitProcedureInvocation(CypherParser::OC_ImplicitProcedureInvocationContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ProcedureResultField(CypherParser::OC_ProcedureResultFieldContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ProcedureName(CypherParser::OC_ProcedureNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Namespace(CypherParser::OC_NamespaceContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Variable(CypherParser::OC_VariableContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Literal(CypherParser::OC_LiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_BooleanLiteral(CypherParser::OC_BooleanLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_NumberLiteral(CypherParser::OC_NumberLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_IntegerLiteral(CypherParser::OC_IntegerLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_DoubleLiteral(CypherParser::OC_DoubleLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ListLiteral(CypherParser::OC_ListLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_MapLiteral(CypherParser::OC_MapLiteralContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_PropertyKeyName(CypherParser::OC_PropertyKeyNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Parameter(CypherParser::OC_ParameterContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SchemaName(CypherParser::OC_SchemaNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_ReservedWord(CypherParser::OC_ReservedWordContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_SymbolicName(CypherParser::OC_SymbolicNameContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_LeftArrowHead(CypherParser::OC_LeftArrowHeadContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_RightArrowHead(CypherParser::OC_RightArrowHeadContext *ctx) override {
    return visitChildren(ctx);
  }

  virtual std::any visitOC_Dash(CypherParser::OC_DashContext *ctx) override {
    return visitChildren(ctx);
  }


};

