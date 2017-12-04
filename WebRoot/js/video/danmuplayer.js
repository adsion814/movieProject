!function(a) {
	a.fn.shCircleLoader = function(b, c) {
		var d = "shcl", e = 1, f = a(this);
		if ("destroy" === b)
			return void f.find("." + d).detach();
		if ("progress" === b && "undefined" != typeof c)
			return void f.each(function() {
						var b = a(this), e = b.find("." + d);
						if (e.get(0)) {
							b.find("span").get(0) || e.append("<span></span>");
							var f = e.find("span").last();
							f.html(c).css({
								position : "absolute",
								display : "block",
								left : Math.round((e.width() - f.width()) / 2)
										+ "px",
								top : Math.round((e.height() - f.height()) / 2)
										+ "px"
							})
						}
					});
		var g = {
			namespace : d,
			radius : "auto",
			dotsRadius : "auto",
			color : "auto",
			dots : 12,
			duration : 1,
			clockwise : !0,
			externalCss : !1,
			keyframes : "0%{{prefix}transform:scale(1)}80%{{prefix}transform:scale(.3)}100%{{prefix}transform:scale(1)}",
			uaPrefixes : ["o", "ms", "webkit", "moz", ""]
		};
		a.extend(g, b);
		for (var h = g.color, i = g.namespace, j = g.dots, k = g.externalCss, l = g.uaPrefixes, m = function(
				a) {
			return a.replace(/(.*)px$/i, "$1")
		}, n = function(a) {
			var b, c, d = "";
			for (b = 0; b < l.length; b++)
				c = l[b].length ? "-" + l[b] + "-" : "", d += a.replace(
						/\{prefix\}/g, c);
			return d
		}, o = function(b, c) {
			var d = {};
			if (b.substr) {
				var e, f;
				for (e = 0; e < l.length; e++)
					f = l[e].length ? "-" + l[e] + "-" : "", d[f + b] = c
			} else
				a.each(b, function(b, c) {
							a.extend(d, o(b, c))
						});
			return d
		}; a("#" + i + e).get(0);)
			e++;
		if (!k) {
			var p = g.keyframes.replace(/\s+$/, "").replace(/^\s+/, "");
			/(\;|\{)\s*visibility\s*\:/gi.test(p)
					|| (p = /^(0+\%|from)\s*\{/i.test(p) ? p.replace(
							/^((0+\%|from)\s*\{)(.*)$/i,
							"$1visibility:visible;$3") : /\s+(0+\%|from)\s*\{/i
							.test(p) ? p.replace(/(\s+(0+\%|from)\s*\{)/i,
							"$1visibility:visible;") : "0%{visibility:visible}"
							+ p), a(a("head").get(0) ? "head" : "body")
					.append('<style id="'
							+ i
							+ e
							+ '" type="text/css">'
							+ n("@{prefix}keyframes " + i + e + "_bounce{" + p
									+ "}") + "</style>")
		}
		f.each(function() {
			var b, c, f, l, n, p, q, r, s, t, u = {}, v = a(this), w = v
					.find("." + d);
			for (w.get(0) && w.shCircleLoader("destroy"), v.html('<div class="'
					+ i + (i != d ? " " + d : "") + '"></div>'), k
					&& (v = v.find("div")), p = v.innerWidth()
					- m(v.css("padding-left")) - m(v.css("padding-right")), q = v
					.innerHeight()
					- m(v.css("padding-top")) - m(v.css("padding-bottom")), b = "auto" == g.radius
					? q > p ? p / 2 : q / 2
					: g.radius, k
					|| (b--, "auto" == g.dotsRadius ? (c = Math.abs(Math
							.sin(Math.PI / (1 * j)))
							* b, c = c * b / (c + b) - 1) : c = g.dotsRadius, v = v
							.find("div"), f = Math.ceil(2 * b), t = {
						position : "relative",
						width : f + "px",
						height : f + "px"
					}, p > f && (t.marginLeft = Math.round((p - f) / 2)), q > f
							&& (t.marginTop = Math.round((q - f) / 2)), v
							.css(t), f = Math.ceil(2 * c) + "px", u = {
						position : "absolute",
						visibility : "hidden",
						width : f,
						height : f
					}, null !== h
							&& (u.background = "auto" == h ? v.css("color") : h), a
							.extend(u, o({
										"border-radius" : Math.ceil(c) + "px",
										"animation-name" : i + e + "_bounce",
										"animation-duration" : g.duration + "s",
										"animation-iteration-count" : "infinite",
										"animation-direction" : "normal"
									}))), f = 0; j > f; f++)
				v.append("<div></div>"), k && "undefined" == typeof c
						&& (c = m(v.find("div").css("width")) / 2), l = v
						.find("div").last(), r = g.duration / j * f, n = 2
						* Math.PI * f / j, s = b - c, p = s * Math.sin(n), q = s
						* Math.cos(n), g.clockwise && (q = -q), t = {
					left : Math.round(p + s) + "px",
					top : Math.round(q + s) + "px"
				}, r && a.extend(t, o("animation-delay", r + "s")), a.extend(t,
						u), l.css(t)
		})
	}
}(jQuery), function(a) {
	a.jQueryPlugin = function(b) {
		a.fn[b] = function(c) {
			var d = Array.prototype.slice.call(arguments, 1);
			return this.length ? this.each(function() {
						var e = a.data(this, b)
								|| a.data(this, b, new cyntax.plugins[b](this,
												c)._init());
						"string" == typeof c
								&& (c = c.replace(/^_/, ""), e[c]
										&& e[c].apply(e, d))
					}) : void 0
		}
	}
}(jQuery);
var cyntax = {
	plugins : {}
};
!function() {
	function a() {
		return (new Date).getTime()
	}
	var b = jQuery, c = "jQuery.pause", d = 1, e = b.fn.animate, f = {};
	b.fn.animate = function(g, h, i, j) {
		var k = b.speed(h, i, j);
		return k.complete = k.old, this.each(function() {
					this[c] || (this[c] = d++);
					var h = b.extend({}, k);
					e.apply(b(this), [g, b.extend({}, h)]), f[this[c]] = {
						run : !0,
						prop : g,
						opt : h,
						start : a(),
						done : 0
					}
				})
	}, b.fn.pause = function() {
		return this.each(function() {
			this[c] || (this[c] = d++);
			var e = f[this[c]];
			e
					&& e.run
					&& (e.done += a() - e.start, e.done > e.opt.duration
							? delete f[this[c]]
							: (b(this).stop().stop().stop(), b(this).stop(), b(this)
									.stop(), b(this).stop(), b(this).stop(), b(this)
									.stop(), b(this).stop(), b(this).stop(), b(this)
									.stop(), b(this).stop(), b(this).stop(), b(this)
									.stop(), b(this).stop(), b(this).stop(), b(this)
									.stop(), e.run = !1))
		})
	}, b.fn.resume = function() {
		return this.each(function() {
			this[c] || (this[c] = d++);
			var g = f[this[c]];
			g
					&& !g.run
					&& (g.opt.duration -= g.done, g.done = 0, g.run = !0, g.start = a(), e
							.apply(b(this), [g.prop, b.extend({}, g.opt)]))
		})
	}
}(), function(a) {
	cyntax.plugins.timer = function(b, c) {
		this.$this = a(b), this.options = a.extend({}, this.defaults, c), this.timer_info = {
			id : null,
			index : null,
			state : 0
		}
	}, cyntax.plugins.timer.prototype = {
		defaults : {
			delay : 1e3,
			repeat : !1,
			autostart : !0,
			callback : null,
			url : "",
			post : ""
		},
		_init : function() {
			return this.options.autostart
					&& (this.timer_info.state = 1, this.timer_info.id = setTimeout(
							a.proxy(this._timer_fn, this), this.options.delay)), this
		},
		_timer_fn : function() {
			"function" == typeof this.options.callback
					? a.proxy(this.options.callback, this.$this).call(this,
							++this.timer_info.index)
					: "string" == typeof this.options.url && (ajax_options = {
						url : this.options.url,
						context : this,
						type : "string" == typeof this.options.post
								&& "" != typeof this.options.post == ""
								? "POST"
								: "GET",
						success : function(a) {
							this.$this.html(a)
						}
					}, "string" == typeof this.options.post
							&& "" != typeof this.options.post
							&& (ajax_options.data = this.options.post), a
							.ajax(ajax_options)), this.options.repeat
					&& 1 == this.timer_info.state
					&& ("boolean" == typeof this.options.repeat || parseInt(this.options.repeat) > this.timer_info.index)
					? this.timer_info.id = setTimeout(a.proxy(this._timer_fn,
									this), this.options.delay)
					: this.timer_id = null
		},
		start : function() {
			0 == this.timer_info.state
					&& (this.timer_info.index = 0, this.timer_info.state = 1, this.timer_id = setTimeout(
							a.proxy(this._timer_fn, this), this.options.delay))
		},
		stop : function() {
			1 == this.timer_info.state && this.timer_info.id
					&& (clearTimeout(this.timer_info.id), this.timer_id = null), this.timer_info.state = 0
		},
		pause : function() {
			1 == this.timer_info.state && this.timer_info.id
					&& clearTimeout(this.timer_info.id), this.timer_info.state = 0
		},
		resume : function() {
			this.timer_info.state = 1, this.timer_id = setTimeout(a.proxy(
							this._timer_fn, this), this.options.delay)
		}
	}, a.jQueryPlugin("timer")
}(jQuery), function(a) {
	function b(b, d) {
		return this.each(function() {
			var e = a(this), f = a.extend({}, c.DEFAULTS, "object" == typeof b
							&& b), g = e.data("danmu"), h = "string" == typeof b
					? b
					: 0 / 0;
			g || e.data("danmu", g = new c(this, f)), h && g[h](d)
		})
	}
	var c = function(b, c) {
		this.$element = a(b), this.options = c, this.id = a(b).attr("id"), a(b)
				.data("nowTime", 0), a(b).data("danmuList", c.danmuList), a(b)
				.data("opacity", c.opacity), a(b).data("paused", 1), a(b).data(
				"topSpace", 0), a(b).data("bottomSpace", 0), this.$element.css(
				{
					position : "absolute",
					left : this.options.left,
					top : this.options.top,
					width : this.options.width,
					height : this.options.height,
					"z-index" : this.options.zindex,
					color : c.defaultFontColor,
					overflow : "hidden"
				});
		var d = this;
		d.height = this.$element.height(), d.width = this.$element.width(), d.speed = 1e3
				/ c.speed, this.launched = [], this.preTime = 0;
		var e = this.options.maxCountInScreen, f = this.options.maxCountPerSec, g = 0, h = 0;
		this.rowCount = parseInt(d.height / c.FontSizeBig), d.options.SubtitleProtection
				&& (d.rowCount = d.rowCount - 3), this.rows = [], this.topRows = [], this.bottomRows = [], this.initRows = function(
				a) {
			for (var b = 0; b < a.rowCount; b++)
				a.rows[b] = 0, a.topRows[b] = 0, a.bottomRows[b] = 0
		}, this.initRows(this), d.getRow = function(a) {
			for (var b = 0; 0 !== a.rows[b];)
				if (b += 1, b >= a.rowCount) {
					a.initRows(a), b = 0;
					break
				}
			return b
		}, d.getTopRow = function(a) {
			for (var b = 0; b < a.topRows.length; b++)
				if (0 == a.topRows[b])
					return b
		}, d.getBottomRow = function(a) {
			for (var b = 0; b < a.bottomRows.length; b++)
				if (0 == a.bottomRows[b])
					return b
		}, d.checkRow = function(b) {
			for (var c in b.rows)
				0 !== b.rows[c]
						&& "undefined" != typeof a("#" + b.rows[c]).position()
						&& a("#" + b.rows[c]).position().left < b.$element
								.width()
								- a("#" + b.rows[c]).width() && (b.rows[c] = 0)
		}, a("<div class='danmakuTimer'></div>").appendTo(this.$element), this.$timer = a(".danmakuTimer"), this.$timer
				.timer({
					delay : 100,
					repeat : c.sumTime,
					autostart : !1,
					callback : function(i) {
						setTimeout(function() {
							d.options.danmuLoop
									&& a(b).data("nowTime") >= a(b)
											.data("sumTime")
									&& a(b).data("nowTime", 0), a(b).data(
									"nowTime", a(b).data("nowTime") + 1), d.height = a(b)
									.height(), d.width = a(b).width(), Math
									.abs(a(b).data("nowTime") - (d.preTime + 1)) > 10
									&& (d.launched = []), d.preTime = a(b)
									.data("nowTime");
							var j = d.rowCount;
							if (d.rowCount = parseInt(d.height / c.FontSizeBig), setTimeout(
									d.checkRow(d), 0), d.options.SubtitleProtection
									&& (d.rowCount = d.rowCount - 3), 0 !== j
									&& d.rowCount !== j && d.initRows(d), h = 0, a(b)
									.data("danmuList")[a(b).data("nowTime")]
									&& d.launched.indexOf(a(b).data("nowTime")) < 0) {
								for (var k = a(b).data("nowTime"), l = a(b)
										.data("danmuList")[k], m = l.length - 1; m >= 0; m--) {
									setTimeout(d.checkRow(d), 0);
									var n = "<span class='danmaku' id='" + d.id
											+ "tempDanmaku'></span>";
									a(b).append(n);
									var o = l[m];
									if (a("#" + d.id + "tempDanmaku")
											.text(o.text).css({
												color : o.color,
												"text-shadow" : " 0px 0px 2px #000000",
												"-moz-opacity" : a(b)
														.data("opacity"),
												opacity : a(b).data("opacity"),
												"white-space" : "nowrap",
												"font-weight" : "bold",
												"font-family" : "SimHei",
												"font-size" : c.FontSizeBig
											}), o.color < "#777777"
											&& a("#" + d.id + "tempDanmaku")
													.css({
														"text-shadow" : " 0px 0px 2px #FFFFFF"
													}), o
											.hasOwnProperty("isnew")
											&& a("#" + d.id + "tempDanmaku")
													.css({
														border : "2px solid "
																+ o.color
													}), 0 == o.size
											&& a("#" + d.id + "tempDanmaku")
													.css("font-size",
															c.fontSizeSmall), 0 == o.position) {
										var p = d.id
												+ "fly"
												+ parseInt((new Date).getTime())
														.toString();
										if (a("#" + d.id + "tempDanmaku").attr(
												"id", p), e >= g && f >= h) {
											d.checkRow(d);
											var q = d.getRow(d);
											d.rows[q] = p, o.row = q;
											var r = q * c.FontSizeBig;
											o.width = a("#" + p).width();
											var s = a("#" + d.id).width();
											a("#" + p).css({
														width : a("#" + p)
																.width(),
														position : "absolute",
														top : r,
														left : s
													});
											var t = (a(b).width() + 400)
													/ d.speed;
											g++, h++, a("#" + p).animate({
												left : -(a("#" + p).width() + 400)
											}, t, function() {
												a(this).remove(), g--, h--
											})
										} else
											a("#" + p).remove()
									} else if (1 == o.position) {
										var u = d.id
												+ "top"
												+ parseInt(1e4 * Math.random())
														.toString();
										a("#" + d.id + "tempDanmaku").attr(
												"id", u);
										var v = d.getTopRow(d);
										a(b)
												.data("topSpace",
														c.FontSizeBig * v), d.topRows[v] = 1, a("#"
												+ u).css({
													width : "100%",
													"text-align" : "center",
													position : "absolute",
													top : a(b).data("topSpace"),
													left : "0"
												}), a("#" + u).data("row", v), a("#"
												+ u).fadeTo(
												c.topBottomDanmuTime,
												a(b).data("opacity"),
												function() {
													d.topRows[a(this)
															.data("row")] = 0, a(this)
															.remove()
												})
									} else if (2 == o.position) {
										var w = d.id
												+ "bottom"
												+ parseInt(1e4 * Math.random())
														.toString();
										a("#" + d.id + "tempDanmaku").attr(
												"id", w);
										var v = d.getBottomRow(d);
										a(b).data("bottomSpace",
												c.FontSizeBig * v), d.bottomRows[v] = 1, a("#"
												+ w).css({
											width : c.width,
											left : "0",
											"text-align" : "center",
											position : "absolute",
											bottom : 0
													+ a(b).data("bottomSpace")
										}), a("#" + w).data("row", v), a("#"
												+ w).fadeTo(
												c.topBottomDanmuTime,
												a(b).data("opacity"),
												function() {
													d.bottomRows[a(this)
															.data("row")] = 0, a(this)
															.remove()
												})
									}
									l[m] = o
								}
								a(b).data("danmuList")[k] = l
							}
							d.launched.push(a(b).data("nowTime")), i == c.sumTime
									&& c.isLoop
									&& (d.$timer.timer("stop"), d.$timer
											.timer("start"))
						})
					}
				})
	};
	c.DEFAULTS = {
		left : 0,
		top : 0,
		height : 360,
		width : 640,
		zindex : 100,
		speed : 8e3,
		sumTime : 65535,
		danmuLoop : !1,
		danmuList : {},
		defaultFontColor : "#FFFFFF",
		fontSizeSmall : 16,
		FontSizeBig : 24,
		opacity : "0.9",
		topBottomDanmuTime : 6e3,
		SubtitleProtection : !1,
		positionOptimize : !1,
		maxCountInScreen : 40,
		maxCountPerSec : 10
	}, c.prototype.danmuStart = function() {
		this.$timer.timer("start"), this.$element.data("paused", 0)
	}, c.prototype.danmuStop = function() {
		this.$timer.timer("stop"), a("#" + this.id + " .danmaku").remove(), nowTime = 0, this.$element
				.data("paused", 1), this.$element.data("nowTime", 0)
	}, c.prototype.danmuPause = function() {
		this.$timer.timer("pause"), a("#" + this.id + " .danmaku").pause(), this.$element
				.data("paused", 1)
	}, c.prototype.danmuResume = function() {
		this.$timer.timer("resume"), a("#" + this.id + " .danmaku").resume(), this.$element
				.data("paused", 0)
	}, c.prototype.danmuHideAll = function() {
		a("#" + this.id + " .danmaku").css({
					opacity : 0
				}), this.initRows(this)
	}, c.prototype.setTime = function(b) {
		a("#" + this.id + " .danmaku").remove(), this.$element.data("nowTime",
				b)
	}, c.prototype.setOpacity = function(b) {
		a("#" + this.id + " .danmaku").css("opacity", b), this.$element.data(
				"opacity", b)
	}, c.prototype.addDanmu = function(a) {
		if (a instanceof Array)
			for (var b in a)
				this.$element.data("danmuList")[a[b].time]
						? this.$element.data("danmuList")[a[b].time].push(a[b])
						: (this.$element.data("danmuList")[a[b].time] = [], this.$element
								.data("danmuList")[a[b].time].push(a[b]));
		else
			this.$element.data("danmuList")[a.time] ? this.$element
					.data("danmuList")[a.time].push(a) : (this.$element
					.data("danmuList")[a.time] = [], this.$element
					.data("danmuList")[a.time].push(a))
	}, a.fn.danmu = b, a.fn.danmu.Constructor = c
}(jQuery), function(a) {
	var b = function() {
		var b = '<div class="colpick"><div class="colpick_color"><div class="colpick_color_overlay1"><div class="colpick_color_overlay2"><div class="colpick_selector_outer"><div class="colpick_selector_inner"></div></div></div></div></div><div class="colpick_hue"><div class="colpick_hue_arrs"><div class="colpick_hue_larr"></div><div class="colpick_hue_rarr"></div></div></div><div class="colpick_new_color"></div><div class="colpick_current_color"></div><div class="colpick_hex_field"><div class="colpick_field_letter">#</div><input type="text" maxlength="6" size="6" /></div><div class="colpick_rgb_r colpick_field"><div class="colpick_field_letter">R</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_rgb_g colpick_field"><div class="colpick_field_letter">G</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_rgb_b colpick_field"><div class="colpick_field_letter">B</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_hsb_h colpick_field"><div class="colpick_field_letter">H</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_hsb_s colpick_field"><div class="colpick_field_letter">S</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_hsb_b colpick_field"><div class="colpick_field_letter">B</div><input type="text" maxlength="3" size="3" /><div class="colpick_field_arrs"><div class="colpick_field_uarr"></div><div class="colpick_field_darr"></div></div></div><div class="colpick_submit"></div></div>', c = {
			showEvent : "click",
			onShow : function() {
			},
			onBeforeShow : function() {
			},
			onHide : function() {
			},
			onChange : function() {
			},
			onSubmit : function() {
			},
			colorScheme : "light",
			color : "3289c7",
			livePreview : !0,
			flat : !1,
			layout : "full",
			submit : 1,
			submitText : "OK",
			height : 156
		}, g = function(b, c) {
			var d = f(b);
			a(c).data("colpick").fields.eq(1).val(d.r).end().eq(2).val(d.g)
					.end().eq(3).val(d.b).end()
		}, i = function(b, c) {
			a(c).data("colpick").fields.eq(4).val(Math.round(b.h)).end().eq(5)
					.val(Math.round(b.s)).end().eq(6).val(Math.round(b.b))
					.end()
		}, j = function(b, c) {
			a(c).data("colpick").fields.eq(0).val(h(b))
		}, k = function(b, c) {
			a(c).data("colpick").selector.css("backgroundColor", "#" + h({
								h : b.h,
								s : 100,
								b : 100
							})), a(c).data("colpick").selectorIndic.css({
						left : parseInt(
								a(c).data("colpick").height * b.s / 100, 10),
						top : parseInt(a(c).data("colpick").height
										* (100 - b.b) / 100, 10)
					})
		}, l = function(b, c) {
			a(c).data("colpick").hue.css("top", parseInt(
							a(c).data("colpick").height
									- a(c).data("colpick").height * b.h / 360,
							10))
		}, m = function(b, c) {
			a(c).data("colpick").currentColor
					.css("backgroundColor", "#" + h(b))
		}, n = function(b, c) {
			a(c).data("colpick").newColor.css("backgroundColor", "#" + h(b))
		}, o = function() {
			var b, c = a(this).parent().parent();
			this.parentNode.className.indexOf("_hex") > 0
					? (c.data("colpick").color = b = d(G(this.value)), g(b, c
									.get(0)), i(b, c.get(0)))
					: this.parentNode.className.indexOf("_hsb") > 0 ? (c
							.data("colpick").color = b = E({
								h : parseInt(c.data("colpick").fields.eq(4)
												.val(), 10),
								s : parseInt(c.data("colpick").fields.eq(5)
												.val(), 10),
								b : parseInt(c.data("colpick").fields.eq(6)
												.val(), 10)
							}), g(b, c.get(0)), j(b, c.get(0))) : (c
							.data("colpick").color = b = e(F({
								r : parseInt(c.data("colpick").fields.eq(1)
												.val(), 10),
								g : parseInt(c.data("colpick").fields.eq(2)
												.val(), 10),
								b : parseInt(c.data("colpick").fields.eq(3)
												.val(), 10)
							})), j(b, c.get(0)), i(b, c.get(0))), k(b, c.get(0)), l(
					b, c.get(0)), n(b, c.get(0)), c.data("colpick").onChange
					.apply(c.parent(), [b, h(b), f(b), c.data("colpick").el, 0])
		}, p = function() {
			a(this).parent().removeClass("colpick_focus")
		}, q = function() {
			a(this).parent().parent().data("colpick").fields.parent()
					.removeClass("colpick_focus"), a(this).parent()
					.addClass("colpick_focus")
		}, r = function(b) {
			b.preventDefault ? b.preventDefault() : b.returnValue = !1;
			var c = a(this).parent().find("input").focus(), d = {
				el : a(this).parent().addClass("colpick_slider"),
				max : this.parentNode.className.indexOf("_hsb_h") > 0
						? 360
						: this.parentNode.className.indexOf("_hsb") > 0
								? 100
								: 255,
				y : b.pageY,
				field : c,
				val : parseInt(c.val(), 10),
				preview : a(this).parent().parent().data("colpick").livePreview
			};
			a(document).mouseup(d, t), a(document).mousemove(d, s)
		}, s = function(a) {
			return a.data.field.val(Math.max(0, Math.min(a.data.max, parseInt(
									a.data.val - a.pageY + a.data.y, 10)))), a.data.preview
					&& o.apply(a.data.field.get(0), [!0]), !1
		}, t = function(b) {
			return o.apply(b.data.field.get(0), [!0]), b.data.el
					.removeClass("colpick_slider").find("input").focus(), a(document)
					.off("mouseup", t), a(document).off("mousemove", s), !1
		}, u = function(b) {
			b.preventDefault ? b.preventDefault() : b.returnValue = !1;
			var c = {
				cal : a(this).parent(),
				y : a(this).offset().top
			};
			a(document).on("mouseup touchend", c, w), a(document).on(
					"mousemove touchmove", c, v);
			var d = "touchstart" == b.type
					? b.originalEvent.changedTouches[0].pageY
					: b.pageY;
			return o
					.apply(
							c.cal.data("colpick").fields
									.eq(4)
									.val(parseInt(
											360
													* (c.cal.data("colpick").height - (d - c.y))
													/ c.cal.data("colpick").height,
											10)).get(0),
							[c.cal.data("colpick").livePreview]), !1
		}, v = function(a) {
			var b = "touchmove" == a.type
					? a.originalEvent.changedTouches[0].pageY
					: a.pageY;
			return o
					.apply(
							a.data.cal.data("colpick").fields
									.eq(4)
									.val(parseInt(
											360
													* (a.data.cal
															.data("colpick").height - Math
															.max(
																	0,
																	Math
																			.min(
																					a.data.cal
																							.data("colpick").height,
																					b
																							- a.data.y)))
													/ a.data.cal
															.data("colpick").height,
											10)).get(0), [a.data.preview]), !1
		}, w = function(b) {
			return g(b.data.cal.data("colpick").color, b.data.cal.get(0)), j(
					b.data.cal.data("colpick").color, b.data.cal.get(0)), a(document)
					.off("mouseup touchend", w), a(document).off(
					"mousemove touchmove", v), !1
		}, x = function(b) {
			b.preventDefault ? b.preventDefault() : b.returnValue = !1;
			var c = {
				cal : a(this).parent(),
				pos : a(this).offset()
			};
			c.preview = c.cal.data("colpick").livePreview, a(document).on(
					"mouseup touchend", c, z), a(document).on(
					"mousemove touchmove", c, y);
			var d;
			return "touchstart" == b.type
					? (pageX = b.originalEvent.changedTouches[0].pageX, d = b.originalEvent.changedTouches[0].pageY)
					: (pageX = b.pageX, d = b.pageY), o
					.apply(
							c.cal.data("colpick").fields
									.eq(6)
									.val(parseInt(
											100
													* (c.cal.data("colpick").height - (d - c.pos.top))
													/ c.cal.data("colpick").height,
											10))
									.end()
									.eq(5)
									.val(parseInt(
											100
													* (pageX - c.pos.left)
													/ c.cal.data("colpick").height,
											10)).get(0), [c.preview]), !1
		}, y = function(a) {
			var b;
			return "touchmove" == a.type
					? (pageX = a.originalEvent.changedTouches[0].pageX, b = a.originalEvent.changedTouches[0].pageY)
					: (pageX = a.pageX, b = a.pageY), o
					.apply(
							a.data.cal.data("colpick").fields
									.eq(6)
									.val(parseInt(
											100
													* (a.data.cal
															.data("colpick").height - Math
															.max(
																	0,
																	Math
																			.min(
																					a.data.cal
																							.data("colpick").height,
																					b
																							- a.data.pos.top)))
													/ a.data.cal
															.data("colpick").height,
											10))
									.end()
									.eq(5)
									.val(parseInt(
											100
													* Math
															.max(
																	0,
																	Math
																			.min(
																					a.data.cal
																							.data("colpick").height,
																					pageX
																							- a.data.pos.left))
													/ a.data.cal
															.data("colpick").height,
											10)).get(0), [a.data.preview]), !1
		}, z = function(b) {
			return g(b.data.cal.data("colpick").color, b.data.cal.get(0)), j(
					b.data.cal.data("colpick").color, b.data.cal.get(0)), a(document)
					.off("mouseup touchend", z), a(document).off(
					"mousemove touchmove", y), !1
		}, A = function() {
			var b = a(this).parent(), c = b.data("colpick").color;
			b.data("colpick").origColor = c, m(c, b.get(0)), b.data("colpick")
					.onSubmit(c, h(c), f(c), b.data("colpick").el)
		}, B = function(b) {
			b.stopPropagation();
			var c = a("#" + a(this).data("colpickId"));
			c.data("colpick").onBeforeShow.apply(this, [c.get(0)]);
			var d = a(this).offset(), e = d.top + this.offsetHeight, f = d.left, g = D(), h = c
					.width();
			f + h > g.l + g.w && (f -= h), c.css({
						left : f + "px",
						top : e + "px"
					}), 0 != c.data("colpick").onShow.apply(this, [c.get(0)])
					&& c.show(), a("html").mousedown({
						cal : c
					}, C), c.mousedown(function(a) {
						a.stopPropagation()
					})
		}, C = function(b) {
			0 != b.data.cal.data("colpick").onHide.apply(this, [b.data.cal
							.get(0)])
					&& b.data.cal.hide(), a("html").off("mousedown", C)
		}, D = function() {
			var a = "CSS1Compat" == document.compatMode;
			return {
				l : window.pageXOffset
						|| (a
								? document.documentElement.scrollLeft
								: document.body.scrollLeft),
				w : window.innerWidth
						|| (a
								? document.documentElement.clientWidth
								: document.body.clientWidth)
			}
		}, E = function(a) {
			return {
				h : Math.min(360, Math.max(0, a.h)),
				s : Math.min(100, Math.max(0, a.s)),
				b : Math.min(100, Math.max(0, a.b))
			}
		}, F = function(a) {
			return {
				r : Math.min(255, Math.max(0, a.r)),
				g : Math.min(255, Math.max(0, a.g)),
				b : Math.min(255, Math.max(0, a.b))
			}
		}, G = function(a) {
			var b = 6 - a.length;
			if (b > 0) {
				for (var c = [], d = 0; b > d; d++)
					c.push("0");
				c.push(a), a = c.join("")
			}
			return a
		}, H = function() {
			var b = a(this).parent(), c = b.data("colpick").origColor;
			b.data("colpick").color = c, g(c, b.get(0)), j(c, b.get(0)), i(c, b
							.get(0)), k(c, b.get(0)), l(c, b.get(0)), n(c, b
							.get(0))
		};
		return {
			init : function(f) {
				if (f = a.extend({}, c, f || {}), "string" == typeof f.color)
					f.color = d(f.color);
				else if (void 0 != f.color.r && void 0 != f.color.g
						&& void 0 != f.color.b)
					f.color = e(f.color);
				else {
					if (void 0 == f.color.h || void 0 == f.color.s
							|| void 0 == f.color.b)
						return this;
					f.color = E(f.color)
				}
				return this.each(function() {
					if (!a(this).data("colpickId")) {
						var c = a.extend({}, f);
						c.origColor = f.color;
						var d = "collorpicker_" + parseInt(1e3 * Math.random());
						a(this).data("colpickId", d);
						var e = a(b).attr("id", d);
						e.addClass("colpick_"
								+ c.layout
								+ (c.submit ? "" : " colpick_" + c.layout
										+ "_ns")), "light" != c.colorScheme
								&& e.addClass("colpick_" + c.colorScheme), e
								.find("div.colpick_submit").html(c.submitText)
								.click(A), c.fields = e.find("input").change(o)
								.blur(p).focus(q), e
								.find("div.colpick_field_arrs").mousedown(r)
								.end().find("div.colpick_current_color")
								.click(H), c.selector = e
								.find("div.colpick_color").on(
										"mousedown touchstart", x), c.selectorIndic = c.selector
								.find("div.colpick_selector_outer"), c.el = this, c.hue = e
								.find("div.colpick_hue_arrs"), huebar = c.hue
								.parent();
						var h = navigator.userAgent.toLowerCase(), s = "Microsoft Internet Explorer" === navigator.appName, t = s
								? parseFloat(h
										.match(/msie ([0-9]{1,}[\.0-9]{0,})/)[1])
								: 0, v = s && 10 > t, w = ["#ff0000",
								"#ff0080", "#ff00ff", "#8000ff", "#0000ff",
								"#0080ff", "#00ffff", "#00ff80", "#00ff00",
								"#80ff00", "#ffff00", "#ff8000", "#ff0000"];
						if (v) {
							var y, z;
							for (y = 0; 11 >= y; y++)
								z = a("<div></div>")
										.attr(
												"style",
												"height:8.333333%; filter:progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr="
														+ w[y]
														+ ", endColorstr="
														+ w[y + 1]
														+ '); -ms-filter: "progid:DXImageTransform.Microsoft.gradient(GradientType=0,startColorstr='
														+ w[y]
														+ ", endColorstr="
														+ w[y + 1] + ')";'), huebar
										.append(z)
						} else
							stopList = w.join(","), huebar
									.attr(
											"style",
											"background:-webkit-linear-gradient(top,"
													+ stopList
													+ "); background: -o-linear-gradient(top,"
													+ stopList
													+ "); background: -ms-linear-gradient(top,"
													+ stopList
													+ "); background:-moz-linear-gradient(top,"
													+ stopList
													+ "); -webkit-linear-gradient(top,"
													+ stopList
													+ "); background:linear-gradient(to bottom,"
													+ stopList + "); ");
						e.find("div.colpick_hue").on("mousedown touchstart", u), c.newColor = e
								.find("div.colpick_new_color"), c.currentColor = e
								.find("div.colpick_current_color"), e.data(
								"colpick", c), g(c.color, e.get(0)), i(c.color,
								e.get(0)), j(c.color, e.get(0)), l(c.color, e
										.get(0)), k(c.color, e.get(0)), m(
								c.color, e.get(0)), n(c.color, e.get(0)), c.flat
								? (e.appendTo(this).show(), e.css({
											position : "relative",
											display : "block"
										}))
								: (e.appendTo(document.body), a(this).on(
										c.showEvent, B), e.css({
											position : "absolute"
										}))
					}
				})
			},
			showPicker : function() {
				return this.each(function() {
							a(this).data("colpickId") && B.apply(this)
						})
			},
			hidePicker : function() {
				return this.each(function() {
							a(this).data("colpickId")
									&& a("#" + a(this).data("colpickId"))
											.hide()
						})
			},
			setColor : function(b, c) {
				if (c = "undefined" == typeof c ? 1 : c, "string" == typeof b)
					b = d(b);
				else if (void 0 != b.r && void 0 != b.g && void 0 != b.b)
					b = e(b);
				else {
					if (void 0 == b.h || void 0 == b.s || void 0 == b.b)
						return this;
					b = E(b)
				}
				return this.each(function() {
					if (a(this).data("colpickId")) {
						var d = a("#" + a(this).data("colpickId"));
						d.data("colpick").color = b, d.data("colpick").origColor = b, g(
								b, d.get(0)), i(b, d.get(0)), j(b, d.get(0)), l(
								b, d.get(0)), k(b, d.get(0)), n(b, d.get(0)), d
								.data("colpick").onChange.apply(d.parent(), [b,
										h(b), f(b), d.data("colpick").el, 1]), c
								&& m(b, d.get(0))
					}
				})
			}
		}
	}(), c = function(a) {
		var a = parseInt(a.indexOf("#") > -1 ? a.substring(1) : a, 16);
		return {
			r : a >> 16,
			g : (65280 & a) >> 8,
			b : 255 & a
		}
	}, d = function(a) {
		return e(c(a))
	}, e = function(a) {
		var b = {
			h : 0,
			s : 0,
			b : 0
		}, c = Math.min(a.r, a.g, a.b), d = Math.max(a.r, a.g, a.b), e = d - c;
		return b.b = d, b.s = 0 != d ? 255 * e / d : 0, b.h = 0 != b.s
				? a.r == d ? (a.g - a.b) / e : a.g == d
						? 2 + (a.b - a.r) / e
						: 4 + (a.r - a.g) / e
				: -1, b.h *= 60, b.h < 0 && (b.h += 360), b.s *= 100 / 255, b.b *= 100
				/ 255, b
	}, f = function(a) {
		var b = {}, c = a.h, d = 255 * a.s / 100, e = 255 * a.b / 100;
		if (0 == d)
			b.r = b.g = b.b = e;
		else {
			var f = e, g = (255 - d) * e / 255, h = (f - g) * (c % 60) / 60;
			360 == c && (c = 0), 60 > c
					? (b.r = f, b.b = g, b.g = g + h)
					: 120 > c
							? (b.g = f, b.b = g, b.r = f - h)
							: 180 > c
									? (b.g = f, b.r = g, b.b = g + h)
									: 240 > c
											? (b.b = f, b.r = g, b.g = f - h)
											: 300 > c
													? (b.b = f, b.g = g, b.r = g
															+ h)
													: 360 > c
															? (b.r = f, b.g = g, b.b = f
																	- h)
															: (b.r = 0, b.g = 0, b.b = 0)
		}
		return {
			r : Math.round(b.r),
			g : Math.round(b.g),
			b : Math.round(b.b)
		}
	}, g = function(b) {
		var c = [b.r.toString(16), b.g.toString(16), b.b.toString(16)];
		return a.each(c, function(a, b) {
					1 == b.length && (c[a] = "0" + b)
				}), c.join("")
	}, h = function(a) {
		return g(f(a))
	};
	a.fn.extend({
				colpick : b.init,
				colpickHide : b.hidePicker,
				colpickShow : b.showPicker,
				colpickSetColor : b.setColor
			}), a.extend({
				colpick : {
					rgbToHex : g,
					rgbToHsb : e,
					hsbToHex : h,
					hsbToRgb : f,
					hexToHsb : d,
					hexToRgb : c
				}
			})
}(jQuery), function(a, b) {
	"use strict";
	function c(c, e) {
		if (this.options = a.extend({}, a.fn[d].defaults, e), this.$trigger = this.$target = c, this.leaveTimeout = null, this.$tooltip714 = a('<div class="tooltip714"> <span></span><div class="pointer714"></div></div>')
				.appendTo(this.options.appendTo).hide(), this.options.contentElem !== b
				&& null !== this.options.contentElem
				? this.options.content = a(this.options.contentElem).html()
				: this.options.contentAttr !== b
						&& null !== this.options.contentAttr
						&& (this.options.content = this.$trigger
								.attr(this.options.contentAttr)), this.$trigger
				&& this.$trigger.attr("title")
				&& this.$trigger.data("originalTitle", this.$trigger
								.attr("title")), this.$tooltip714.find("span")
				.html(this.options.content), "" != this.options.cssclass
				&& this.$tooltip714.addClass(this.options.cssclass), this.options.target !== b
				&& (this.$target = a(this.options.target)), this.options.hoverable) {
			var f = this;
			this.$tooltip714.on("mouseenter." + d,
					a.proxy(this.do_mouseenter, f)).on("mouseleave." + d,
					a.proxy(this.do_mouseleave, f)).on("close." + d,
					a.proxy(this.hide, f))
		}
	}
	var d = "scojs_tooltip";
	a.extend(c.prototype, {
		show : function(c) {
			c === b && (c = !1), this.$tooltip714
					.removeClass("pos_w pos_e pos_n pos_s pos_nw pos_ne pos_se pos_sw pos_center")
					.addClass("pos_" + this.options.position);
			{
				var d = this.$target.offset(), e = {
					left : 0,
					top : 0,
					width : Math.floor(this.$tooltip714.outerWidth()),
					height : Math.floor(this.$tooltip714.outerHeight())
				}, f = {
					left : 0,
					top : 0,
					width : Math.floor(this.$tooltip714.find(".pointer")
							.outerWidth()),
					height : Math.floor(this.$tooltip714.find(".pointer")
							.outerHeight())
				};
	({
					left : a(document).scrollLeft(),
					top : a(document).scrollTop(),
					width : a(window).width(),
					height : a(window).height()
				})
			}
			return d.left = Math.floor(d.left), d.top = Math.floor(d.top), d.width = Math
					.floor(this.$target.outerWidth()), d.height = Math
					.floor(this.$target.outerHeight()), "w" === this.options.position
					? (e.left = d.left - e.width - f.width, e.top = d.top
							+ Math.floor((d.height - e.height) / 2), f.left = e.width, f.top = Math
							.floor(d.height / 2))
					: "e" === this.options.position
							? (e.left = d.left + d.width + f.width, e.top = d.top
									+ Math.floor((d.height - e.height) / 2), f.left = -f.width, f.top = Math
									.floor(e.height / 2))
							: "n" === this.options.position
									? (e.left = d.left
											- Math.floor((e.width - d.width)
													/ 2)
											- Math
													.floor(a(this.options.appendTo)
															.offset().left), e.top = d.top
											- e.height
											- Math
													.floor(a(this.options.appendTo)
															.offset().top), f.left = Math
											.floor(e.width / 2), f.top = e.height)
									: "s" === this.options.position
											? (e.left = d.left
													- Math
															.floor((e.width - d.width)
																	/ 2), e.top = d.top
													+ d.height + f.height, f.left = Math
													.floor(e.width / 2), f.top = -f.height)
											: "nw" === this.options.position
													? (e.left = d.left
															- e.width + f.width, e.top = d.top
															- e.height
															- f.height, f.left = e.width
															- f.width, f.top = e.height)
													: "ne" === this.options.position
															? (e.left = d.left
																	+ d.width
																	- f.width, e.top = d.top
																	- e.height
																	- f.height, f.left = 1, f.top = e.height)
															: "se" === this.options.position
																	? (e.left = d.left
																			+ d.width
																			- f.width, e.top = d.top
																			+ d.height
																			+ f.height, f.left = 1, f.top = -f.height)
																	: "sw" === this.options.position
																			? (e.left = d.left
																					- e.width
																					+ f.width, e.top = d.top
																					+ d.height
																					+ f.height, f.left = e.width
																					- f.width, f.top = -f.height)
																			: "center" === this.options.position
																					&& (e.left = d.left
																							+ Math
																									.floor((d.width - e.width)
																											/ 2), e.top = d.top
																							+ Math
																									.floor((d.height - e.height)
																											/ 2), c = !1, this.$tooltip714
																							.find(".pointer")
																							.hide()), this.$tooltip714
					.css({
								left : e.left,
								top : e.top
							}), this.$trigger.removeAttr("title"), this.$tooltip714
					.show(), this
		},
		hide : function() {
			this.$trigger.data("originalTitle")
					&& this.$trigger.attr("title", this.$trigger
									.data("originalTitle")), "function" == typeof this.options.on_close
					&& this.options.on_close.call(this), this.$tooltip714
					.hide()
		},
		do_mouseenter : function() {
			null !== this.leaveTimeout
					&& (clearTimeout(this.leaveTimeout), this.leaveTimeout = null), this
					.show()
		},
		do_mouseleave : function() {
			var a = this;
			null !== this.leaveTimeout
					&& (clearTimeout(this.leaveTimeout), this.leaveTimeout = null), this.options.autoclose
					&& (this.leaveTimeout = setTimeout(function() {
								clearTimeout(a.leaveTimeout), a.leaveTimeout = null, a
										.hide()
							}, this.options.delay))
		}
	}), a.fn[d] = function(b) {
		var e = null, f = !1;
		return "string" == typeof b && (e = b), this.each(function() {
			var g;
			if (!(g = a.data(this, d))) {
				var h, i = a(this), j = i.data();
				f = !0, h = "object" == typeof b ? a.extend({}, b, j) : j, g = new c(
						i, h), a.data(this, d, g)
			}
			e ? g[e]() : f ? a(this).on("mouseenter." + d, function() {
						g.do_mouseenter()
					}).on("mouseleave." + d, function() {
						g.do_mouseleave()
					}) : g.show()
		})
	}, a[d] = function(b, d) {
		return "string" == typeof b && (b = a(b)), new c(b, d)
	}, a.fn[d].defaults = {
		contentElem : null,
		contentAttr : null,
		content : "",
		hoverable : !0,
		delay : 0,
		cssclass : "",
		position : "n",
		autoclose : !0,
		appendTo : "body"
	}, a(document).on("mouseenter." + d, '[data-trigger="tooltip"]',
			function() {
				a(this)[d]("do_mouseenter")
			}).on("mouseleave." + d, '[data-trigger="tooltip"]', function() {
				a(this)[d]("do_mouseleave")
			}), a(document).off("click." + d, '[data-dismiss="tooltip"]').on(
			"click." + d, '[data-dismiss="tooltip"]', function() {
				a(this).closest(".tooltip").trigger("close")
			})
}(jQuery), function($) {
	function Plugin(a, b) {
		return this.each(function() {
			var c = $(this), d = $.extend({}, DanmuPlayer.DEFAULTS,
					"object" == typeof a && a), e = c.data("DanmuPlayer"), f = "string" == typeof a
					? a
					: 0 / 0;
			e || c.data("danmu", e = new DanmuPlayer(this, d)), f && e[f](b)
		})
	}
	var DanmuPlayer = function(element, options) {
		this.$element = $(element), this.options = options, $(element).data(
				"paused", 1);
		var that = this;
		this.$element.css({
					position : "relation",
					width : this.options.width,
					height : this.options.height,
					overflow : "hidden"
				}), this.$element.addClass("danmu-player"), $(element)
				.attr("id")
				|| $(element).attr("id", (65535 * Math.random()).toString()), this.id = "#"
				+ $(element).attr("id"), this.$element
				.append('<div class="danmu-div"id="' + $(element).attr("id")
						+ '-danmu-div" ></div>'), $(this.id + " .danmu-div")
				.danmu({
							width : "100%",
							height : "100%",
							speed : options.speed,
							opacity : options.opacity,
							fontSizeSmall : options.fontSizeSmall,
							FontSizeBig : options.FontSizeBig,
							topBottonDanmuTime : options.topBottonDanmuTime,
							SubtitleProtection : !0,
							positionOptimize : !0
						}), this.$element.css("height", this.$element.height()
						+ 40), this.$element
				.append('<video class="danmu-video" id="danmuvideoplay" src="' + options.src
						+ '" width="' + options.width + '" height="'
						+ options.height + '"></video>'), this.$element
				.append('<div class="danmu-player-load" ></div>'), this.$element
				.append('<div class="danmu-player-ctrl" ></div>'), this.$element
				.append('<div class="danmu-player-tip" ></div>'), this.$tip = $(this.id
				+ " .danmu-player-tip"), this.$ctrl = $(this.id
				+ " .danmu-player-ctrl"), this.$ctrl
				.append('<div class="ctrl-progress"><div class="current"><div class="progress-handle"></div></div><div class="buffered"></div></div>'), this.$ctrl
				.append('<div class="ctrl-main"></div>'), this.$ctrlMain = $(this.id
				+ " .ctrl-main"), this.$ctrlMain
				.append('<div class="play-btn ctrl-btn"><span class="glyphicon glyphicon-play" aria-hidden="true"></span></div>'), this.$ctrlMain
				.append('<div class="current-time time-text ctrl-btn">0:00</div>'), this.$ctrlMain
				.append('<div class="slash time-text ctrl-btn">/</div>'), this.$ctrlMain
				.append('<div class="duration ctrl-btn time-text" >0:00</div>'), this.$ctrlMain
				.append('<div class="opt-btn ctrl-btn " ><span class="glyphicon glyphicon-text-color" aria-hidden="true"></div>'), this.$ctrlMain
				.append('<input class="danmu-input ctrl-btn"   type="textarea" id="danmu_text" max=300 />'), this.$ctrlMain
				.append('<div class=" send-btn  ctrl-btn"  >发送 ></div>'), this.$ctrlMain
				.append('<div class="full-screen   ctrl-btn-right"><span class=" glyphicon glyphicon-resize-full" aria-hidden="true"></span></div>'), this.$ctrlMain
				.append('<div class="loop-btn   ctrl-btn-right"><span class="glyphicon glyphicon-retweet" aria-hidden="true"></span></div>'), this.$ctrlMain
				.append('<div class="show-danmu  ctrl-btn-right ctrl-btn-right-active"><span class="glyphicon glyphicon-comment" aria-hidden="true"></span></div>'), this.$ctrlMain
				.append('<div class="opacity ctrl-btn-right"><input class="ctrl-btn-right danmu-op" value="100" type="range" /></div>'), $("body")
				.append('<div id="'
						+ this.id.slice(1, this.id.length)
						+ 'fontTip"  hidden="true"><form  id="danmu-position">弹幕位置：<input type="radio" checked="checked"  name="danmu_position" value=0 />滚动&nbsp;&nbsp;<input type="radio" name="danmu_position" value=1 />顶端&nbsp;&nbsp;<input type="radio" name="danmu_position" value=2 />底端&nbsp;&nbsp;</form><form  id="danmu-size" >弹幕大小：<input   type="radio" checked="checked"  name="danmu_size" value="1" />大文字&nbsp;&nbsp;<input   type="radio" name="danmu_size" value="0" />小文字&nbsp;&nbsp;</form><div class="colpicker" ></div></div>'), this.video = $(this.id
				+ " .danmu-video").get(0), this.current = 0, this.duration = this.video.duration, this.danmuPlayerFullScreen = !1, this.danmuShowed = !0, this.isLoop = !1, this.danmuSize = 0, this.danmuColor = this.options.defaultColor, this.danmuPosition = 0, $(this.id
				+ " .danmu-player-load").shCircleLoader({
			keyframes : "0%   {background:black}\r\n         40%  {background:transparent}\r\n         60%  {background:transparent}\r\n         100% {background:black}"
		});
		var temFontTipID = this.id + "fontTip";
		$(this.id + " .opt-btn").scojs_tooltip({
					appendTo : this.id,
					contentElem : temFontTipID,
					position : "n"
				}), $(this.id + " .opacity").scojs_tooltip({
					appendTo : this.id,
					content : "弹幕透明度"
				}), $(this.id + " .show-danmu").scojs_tooltip({
					appendTo : this.id,
					content : "开启/关闭 弹幕"
				}), $(this.id + " .loop-btn").scojs_tooltip({
					appendTo : this.id,
					content : "循环播放"
				}), $(this.id + " .full-screen").scojs_tooltip({
					appendTo : this.id,
					content : "全屏"
				}), $(this.id + " .colpicker").colpick({
					flat : !0,
					layout : "hex",
					submit : 0,
					color : "ffffff",
					onChange : function(a, b) {
						that.danmuColor = "#" + b
					}
				}), this.getDanmu = function() {
			$.get(that.options.urlToGetDanmu, function(data, status) {
		
						danmuFromSql = eval(data);
								console.debug(danmuFromSql);
						for (var i = 0; i < danmuFromSql.length; i++) {
							try {
								var danmuLs = eval( danmuFromSql[i])
							} catch (e) {
								continue
							}
							$(that.id + " .danmu-div").danmu("addDanmu",
									danmuLs)
						}
					})
		}, options.urlToGetDanmu && this.getDanmu(), this.sendDanmu = function(
				e) {
			var text = $(e.data.that.id + " .danmu-input").get(0).value;
			if (0 != text.length) {
				if (text.length > 255)
					return void alert("弹幕过长！");
				text = text.replace(/&/g, "&gt;").replace(/</g, "&lt;")
						.replace(/>/g, "&gt;").replace(/\"/g, "&quot;")
						.replace(/\n/g, "<br>");
				var color = e.data.that.danmuColor, position = $(e.data.that.id
						+ " input[name=danmu_position]:checked").val(), size = $(e.data.that.id
						+ " input[name=danmu_size]:checked").val(), time = $(e.data.that.id
						+ " .danmu-div").data("nowTime")
						+ 3, textObj = '{ "text":"' + text + '","color":"'
						+ color + '","size":"' + size + '","position":"'
						+ position + '","time":' + time + "}";
						
				e.data.that.options.urlToPostDanmu
						&&$.ajax({
						type:"post",
						url:e.data.that.options.urlToPostDanmu,
						contentType:"application/json;charset=utf-8",
						data:textObj
					
					
						}) /*$.post(e.data.that.options.urlToPostDanmu, {
									danmu : JSON.parse(textObj)
								},function(data){cosole.debug(data)},"json")*/, textObj = '{ "text":"' + text
						+ '","color":"' + color + '","size":"' + size
						+ '","position":"' + position + '","time":' + time
						+ ',"isnew":""}';
				var newObj = eval("(" + textObj + ")");
		
                        console.debug(JSON.parse(textObj));
				$(e.data.that.id + " .danmu-div").danmu("addDanmu", newObj), $(e.data.that.id
						+ " .danmu-input").get(0).value = "", $(e.data.that)
						.trigger("senddanmu")
			}
		}, this.playPause = function(a) {
			a.data.video.paused
					? (a.data.video.play(), $(a.data.that.id + " .danmu-div")
							.danmu("danmuResume"), $(a.data.that.id
							+ " .play-btn span").removeClass("glyphicon-play")
							.addClass("glyphicon-pause"))
					: (a.data.video.pause(), $(a.data.that.id + " .danmu-div")
							.danmu("danmuPause"), $(a.data.that.id
							+ " .play-btn span").removeClass("glyphicon-pause")
							.addClass("glyphicon-play"))
		};
		var mainTimer = setInterval(function() {
					var a = $(that.id + " .danmu-video").get(0).buffered
							.end($(that.id + " .danmu-video").get(0).buffered.length
									- 1), b = a / that.duration * 100;
					$(that.id + ".danmu-player .ctrl-progress .buffered ").css(
							"width", b + "%")
				}, 1e3), secTimer = setInterval(function() {
					$(that.id + " .danmu-div").data("nowTime",
							parseInt(10 * that.video.currentTime))
				}, 50);
		$(document).ready(function() {
					jQuery("body").keydown({
								that : that
							}, function(a) {
								return 13 == a.which
										? (that.sendDanmu(a), !1)
										: void 0
							})
				}), $(this.id + " .play-btn").on("click", {
					video : this.video,
					that : that
				}, function(a) {
					that.playPause(a)
				}), $(this.id + " .danmu-div").on("click", {
					video : this.video,
					that : that
				}, function(a) {
					that.playPause(a)
				}), $(this.id + " .danmu-video").on("waiting", {
					that : that
				}, function(a) {
					0 == $(a.data.that.id + " .danmu-video").get(0).currentTime
							? ($(a.data.that.id + " .danmu-div").data(
									"nowTime", 0), $(a.data.that.id
									+ " .danmu-div").data("danmuPause"))
							: ($(a.data.that.id + " .danmu-div")
									.data(
											"nowTime",
											10
													* parseInt($(a.data.that.id
															+ " .danmu-video")
															.get(0).currentTime)), $(a.data.that.id
									+ " .danmu-div").data("danmuPause")), $(a.data.that.id
							+ " .danmu-player-load").css("display", "block")
				}), $(this.id + " .danmu-video").on("play playing", {
					that : that
				}, function(a) {
					0 == $(a.data.that.id + " .danmu-video").get(0).currentTime
							? ($(a.data.that.id + " .danmu-div").data(
									"nowTime", 0), $(a.data.that.id
									+ " .danmu-div").data("danmuResume"))
							: ($(a.data.that.id + " .danmu-div")
									.data(
											"nowTime",
											10
													* parseInt($(a.data.that.id
															+ " .danmu-video")
															.get(0).currentTime)), $(a.data.that.id
									+ " .danmu-div").data("danmuResume")), $(a.data.that.id
							+ " .danmu-player-load").css("display", "none")
				}), $(this.id + " .danmu-video").on("seeked ", {
					that : that
				}, function(a) {
					$(a.data.that.id + " .danmu-div").danmu("danmuHideAll")
				}), $(this.id + " .danmu-op").on("mouseup touchend", {
					that : that
				}, function(a) {
					$(a.data.that.id + " .danmu-div").data("opacity",
							a.target.value / 100), $(a.data.that.id
							+ " .danmaku").css("opacity", a.target.value / 100)
				}), $(this.id + " .full-screen").on("click", {
					video : this.video,
					that : that
				}, function(a) {
					a.data.that.danmuPlayerFullScreen
							? ($(a.data.that.id)
									.removeClass("danmu-player-full-screen"), a.data.that.danmuPlayerFullScreen = !1, $(a.data.that.id
									+ " .full-screen span")
									.removeClass("glyphicon-resize-small")
									.addClass("glyphicon-resize-full"))
							: ($(a.data.that.id)
									.addClass("danmu-player-full-screen"), a.data.that.danmuPlayerFullScreen = !0, $(a.data.that.id
									+ " .full-screen span")
									.removeClass("glyphicon-resize-full")
									.addClass("glyphicon-resize-small"))
				}), $(this.id + " .show-danmu").on("click", {
					that : that
				}, function(a) {
					a.data.that.danmuShowed
							? ($(a.data.that.id + " .danmu-div").css(
									"visibility", "hidden"), a.data.that.danmuShowed = !1, $(a.data.that.id
									+ " .show-danmu")
									.removeClass("ctrl-btn-right-active"))
							: (a.data.that.danmuShowed = !0, $(a.data.that.id
									+ " .danmu-div").css("visibility",
									"visible"), $(a.data.that.id
									+ " .show-danmu")
									.addClass("ctrl-btn-right-active"))
				}), $(this.id + " .loop-btn").on("click", {
					that : that
				}, function(a) {
					a.data.that.isLoop
							? (a.data.that.video.loop = !0, a.data.that.isLoop = !1, $(a.data.that.id
									+ " .loop-btn")
									.removeClass("ctrl-btn-right-active"))
							: (a.data.that.video.loop = !0, a.data.that.isLoop = !0, $(a.data.that.id
									+ " .loop-btn")
									.addClass("ctrl-btn-right-active"))
				}), $(this.id + " .danmu-video").on("loadedmetadata", {
					video : this.video,
					that : that
				}, function(a) {
					a.data.that.duration = a.data.video.duration;
					var b = parseInt(a.data.that.duration / 60), c = parseInt(a.data.that.duration
							% 60) < 10
							? "0" + parseInt(a.data.that.duration % 60)
							: parseInt(a.data.that.duration % 60);
					$(a.data.that.id + " .duration").text(b + ":" + c), $(a.data.that.id
							+ " .danmu-video").on("timeupdate", {
								video : a.data.video,
								that : a.data.that
							}, function(a) {
								var b = a.data.that.current = a.data.video.currentTime, c = parseInt(b
										/ 60), d = parseInt(b % 60) < 10 ? "0"
										+ parseInt(b % 60) : parseInt(b % 60);
								$(a.data.that.id + " .current-time").text(c
										+ ":" + d);
								var e = parseInt(a.data.that.duration / 60), f = parseInt(a.data.that.duration
										% 60) < 10
										? "0"
												+ parseInt(a.data.that.duration
														% 60)
										: parseInt(a.data.that.duration % 60);
								$(a.data.that.id + " .duration").text(e + ":"
										+ f);
								var g = 100 * b / a.data.that.duration;
								$(a.data.that.id
										+ ".danmu-player .ctrl-progress .current ")
										.css("width", g + "%"), a.data.that.reviseFlag = a.data.that.reviseFlag
										+ 1
							})
				}), $(this.id + " .ctrl-progress").on("click", {
					video : this.video,
					that : that
				}, function(a) {
					var b = $(a.data.that.id + " .ctrl-progress").width(), c = a.pageX
							- $(a.data.that.id + " .ctrl-progress").offset().left, d = c
							/ b;
					$(a.data.that.id + ".danmu-player .ctrl-progress .current ")
							.css("width", 100 * d + "%"), aimTime = parseFloat(d
							* a.data.that.duration), a.data.video.currentTime = aimTime
				});
		var timeDrag = !1;
		$(this.id + " .ctrl-progress").on("mousedown touchstart", function() {
					timeDrag = !0
				}), $(document).on("mouseup", function() {
					timeDrag && (timeDrag = !1)
				}), $(this.id + " .ctrl-progress").on("mousemove touchmove", {
					video : this.video,
					that : that
				}, function(a) {
					if (timeDrag) {
						var b = $(a.data.that.id + " .ctrl-progress").width(), c = a.pageX
								- $(a.data.that.id + " .ctrl-progress")
										.offset().left, d = c / b;
						d > 1 && (d = 1), 0 > d && (d = 0), aimTime = parseFloat(d
								* a.data.that.duration), a.data.video.currentTime = aimTime, $(a.data.that.id
								+ ".danmu-player .ctrl-progress .current ")
								.css("width", 100 * d + "%")
					}
				}), $(this.id + " .send-btn").on("click", {
					that : that
				}, function(a) {
					a.data.that.sendDanmu(a)
				}), $(this.id + " .ctrl-progress").on("mouseup touchend", {
					that : that
				}, function(a) {
					$(a.data.that.id + " .danmaku").remove()
				})
	};
	DanmuPlayer.DEFAULTS = {
		left : 0,
		top : 0,
		height : 360,
		width : 640,
		zindex : 100,
		speed : 8e3,
		sumTime : 65535,
		defaultColor : "#ffffff",
		fontSizeSmall : 16,
		FontSizeBig : 24,
		opacity : "1",
		topBottonDanmuTime : 6e3,
		urlToGetDanmu : "",
		urlToPostDanmu : ""
	}, $.fn.DanmuPlayer = Plugin, $.fn.DanmuPlayer.Constructor = DanmuPlayer
}(jQuery);