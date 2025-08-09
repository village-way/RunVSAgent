// SPDX-FileCopyrightText: 2025 Weibo, Inc.
//
// SPDX-License-Identifier: Apache-2.0

package com.sina.weibo.agent.actions

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.project.Project
import com.sina.weibo.agent.core.PluginContext
import com.sina.weibo.agent.core.ServiceProxyRegistry
/**
 * Executes a VSCode command with the given command ID.
 * This function uses the RPC protocol to communicate with the extension host.
 *
 * @param commandId The identifier of the command to execute
 * @param project The current project context
 */
fun executeCommand(commandId: String, project: Project?) {
    val proxy =
        project?.getService(PluginContext::class.java)?.getRPCProtocol()?.getProxy(ServiceProxyRegistry.ExtHostContext.ExtHostCommands)
    proxy?.executeContributedCommand(commandId, emptyList())
}

/**
 * Action that handles clicks on the Plus button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class PlusButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(PlusButtonClickAction::class.java)
    private val commandId: String = "zhanlu.plusButtonClicked"

    /**
     * Performs the action when the Plus button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("Plus button clicked")
        executeCommand(commandId,e.project)
    }
}

/**
 * Action that handles clicks on the Prompts button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class PromptsButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(PromptsButtonClickAction::class.java)
    private val commandId: String = "zhanlu.promptsButtonClicked"

    /**
     * Performs the action when the Prompts button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("Prompts button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that handles clicks on the MCP button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class MCPButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(MCPButtonClickAction::class.java)
    private val commandId: String = "zhanlu.mcpButtonClicked"

    /**
     * Performs the action when the MCP button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("MCP button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that handles clicks on the History button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class HistoryButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(HistoryButtonClickAction::class.java)
    private val commandId: String = "zhanlu.historyButtonClicked"

    /**
     * Performs the action when the History button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("History button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that handles clicks on the Settings button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class SettingsButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(SettingsButtonClickAction::class.java)
    private val commandId: String = "zhanlu.settingsButtonClicked"

    /**
     * Performs the action when the Settings button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("Settings button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that handles clicks on the Marketplace button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class MarketplaceButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(MarketplaceButtonClickAction::class.java)
    private val commandId: String = "zhanlu.marketplaceButtonClicked"

    /**
     * Performs the action when the Marketplace button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("Marketplace button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that handles clicks on the Account button in the UI.
 * Executes the corresponding VSCode command when triggered.
 */
class AccountButtonClickAction : AnAction() {
    private val logger: Logger = Logger.getInstance(AccountButtonClickAction::class.java)
    private val commandId: String = "zhanlu.accountButtonClicked"

    /**
     * Performs the action when the Account button is clicked.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        logger.info("Account button clicked")
        executeCommand(commandId, e.project)
    }
}

/**
 * Action that opens developer tools for the WebView.
 * Takes a function that provides the current WebView instance.
 *
 * @property getWebViewInstance Function that returns the current WebView instance or null if not available
 */
class OpenDevToolsAction(private val getWebViewInstance: () -> com.sina.weibo.agent.webview.WebViewInstance?) : AnAction("Open Developer Tools") {
    private val logger: Logger = Logger.getInstance(OpenDevToolsAction::class.java)

    /**
     * Performs the action to open developer tools for the WebView.
     *
     * @param e The action event containing context information
     */
    override fun actionPerformed(e: AnActionEvent) {
        val webView = getWebViewInstance()
        if (webView != null) {
            webView.openDevTools()
        } else {
            logger.warn("No WebView instance available, cannot open developer tools")
        }
    }
}
