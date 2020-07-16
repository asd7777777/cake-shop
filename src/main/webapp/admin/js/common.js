/**
 * 用来截取地址栏的参数值
 * @param name
 * @returns {string|null}
 */
function getQueryString(name) {
    let reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    let r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return unescape(r[2])
    }
    return null;
}